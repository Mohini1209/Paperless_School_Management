import React from 'react';
import ReactDOM from 'react-dom';
import  Select from 'react-select';
//import '../index.css';
//import 'bootstrap/dist/css/bootstrap.min.css';

import AllQueries from './AllQueries.js';

class AnswerQuery extends React.Component{
    constructor(props)
      {
          super(props);
          this.state = { 
             subjects:[],
             students:[],
             queries:[],
             selectSubValue : 0,
             selectStudentValue : 0,
             selectedOption: null,
             querywithanswer:[{"qanswer":null,"qtext":null,"subject_id":null,"student_id":null}]
           }

           this.handleSubChange = this.handleSubChange.bind(this);
           this.handleStudentChange = this.handleStudentChange.bind(this);

      }

      componentDidMount=()=>
      {

        fetch("http://localhost:8080/selectsubject?user_id="+sessionStorage.getItem("teacher_id"),{method:'post'})
       .then(response=> response.json())
       .then(
           (result) => {
          //  alert(JSON.stringify(result));
           this.setState({
               subjects: result
             });
           })
           
           fetch("http://localhost:8080/studlist?user_id=" + sessionStorage.getItem("teacher_id"))        
        .then(response=> response.json())
        .then(
            (res) => {
            //  alert(JSON.stringify(res));
            //  alert(res.length);
            this.setState({
                students: res,
              
              });
            
            })
    }

    handleSubChange(e){
        this.setState({selectSubValue: e.target.value});
        
    }
    handleStudentChange(e){
        this.setState({selectStudentValue: e.target.value});
        
    }

    showQueries = () =>{
        // alert("Method call");
        fetch("http://localhost:8080/fetchquery?subject_id="+(this.state.selectSubValue)+"&s_id="+(this.state.selectStudentValue),{method:'post'})
        .then(response=> response.json())
        .then(
            (data) => {

            //  alert(JSON.stringify(data));

             var lQuestionAnswerData= data;
             var larrlQuestionAnswer=[];
             for(var lobj in lQuestionAnswerData){
                 debugger;
                 larrlQuestionAnswer.push(
                     //{"date":null,"remark":null,"s_id":lStudentData[lobj]["s_id"],"student_name":lStudentData[lobj]["first_name"]+" "+lStudentData[lobj]["last_name"]}
                     {"qanswer":lQuestionAnswerData[lobj]["answer"],"qtext":lQuestionAnswerData[lobj]["question"],"subject_id":this.state.selectSubValue,"student_id":this.state.selectStudentValue}
                 )
             }
             this.setState({querywithanswer:larrlQuestionAnswer});

            // this.setState({
            //     queries: data
            //   });
            })

    }

    handleRemarkChange = i => e =>{
        debugger;
        const { name, value } = e.target;
        const lquerywithanswer = [...this.state.querywithanswer];
        lquerywithanswer[i][name] = value;
        this.setState({ lquerywithanswer });
       
      };

      insertAttendence = () =>
      {
          debugger;
      console.log(this.state.querywithanswer);
      const requestOptions = {
      method: 'POST',
      headers:{
        'Content-Type':'application/json'
      },
      body: JSON.stringify(
       
        this.state.lquerywithanswer
      ), 
    }

    fetch("http://localhost:8080/answerQuery",requestOptions);
     alert("Answer inserted/updated successfully");
}

      render()
      {  
          return(
            <div className="container-fuild" >
                  
                  <form className="form-group">
                  <table className="table table-hover, table-bordered">
                  <tr>
                        <td colspan="2" style={{fontSize:"20px",fontWeight : "bold"}}>Select Subject </td>
                        <td>
                        <select name="subject" ref="subjects" className="form-control"  value={this.state.selectSubValue}
        onChange={this.handleSubChange} >
                                <option>Select Subject</option>
                                     {
                                         
                                         this.state.subjects.map(s=>
                                             { return(
                                                  <option value={s.subject_id}>{s.subject_name}</option>
                                              )  }
                                         )
                                     }
                                 </select> 
                        </td>
                        <td>{this.state.selectSubValue}</td>
                    </tr>
                    <tr>
                        <td colspan="2" style={{fontSize:"20px",fontWeight : "bold"}}>Select Student </td>
                        <td>
                        <select name="chapters" className="form-control" value={this.state.selectStudentValue}
        onChange={this.handleStudentChange} >
                                <option>Select Student</option>
                                     {
                                         
                                         this.state.students.map(st=>
                                             { return(
                                                  <option value={st.s_id}>{st.first_name+" "+st.last_name}</option>
                                              )  }
                                         )
                                     }
                                 </select> 
                        </td>
                        <td>{this.state.selectStudentValue}</td>
                    </tr>
                    
                      <tr> 
                          <td colspan="3"><input type="button" className="btn btn-block btn-primary" onClick={this.showQueries} value="Show Queries"/></td>
                      </tr>
                      
                      
                  </table>
                  <table className="table table-hover, table-bordered">
                        <tr>
                            <th>Query</th>
                            <th>Answer</th>
                        </tr>
                        {

                            this.state.querywithanswer.map((t,i) => {
                                return (
                                    <tr>
                                         <td>{t.qtext}</td>
                                        <td><input value={t.qanswer} type="text" name="qanswer" placeholder="Enter Answer here" className="form-control" onChange={this.handleRemarkChange(i)} /></td>
                                    </tr>
                                   
                                )
                            }
                            )
                        }
                        <tr>
                            <td colspan="2"><input type="button" className="btn btn-block btn-primary" onClick={this.insertAttendence} value="Submit Answer" /></td>
                        </tr>
                        
                    </table>
                  </form>
                  
                  <br/>
                  
              </div>      
              
          );
      }
    }



export default AnswerQuery;
