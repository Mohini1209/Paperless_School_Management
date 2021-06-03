import React from 'react';
import  Select from 'react-select';


class RaiseQuery extends React.Component{
    constructor(props)
    {
        super(props);
        this.state = { 
            msg : "",
            loginerror : "",
            students : "",
            subjects : [],
            onesub : [],
            query :[{question:null, answer:null,subject_id:null, s_id:null}],
            querySubmit :{question:null, answer:null,subject_id:null, s_id:null},
            selectSubValue : null,
            selectedOption: null
         };
         this.handleChange = this.handleChange.bind(this);
    }

    componentDidMount() {
       
            // alert(sessionStorage.getItem("student_id"));
          fetch("http://localhost:8080/selectsub?user_id="+(sessionStorage.getItem("student_id")))
          .then(response=> response.json())
          .then(
              (result) => {
              //  alert(JSON.stringify(result));
              this.setState({
                  subjects: result
                });
              })

             // alert(sessionStorage.getItem("student_id"));
              fetch("http://localhost:8080/studentquery?user_id="+(sessionStorage.getItem("student_id")))
              .then(response=> response.json())
             
              .then(
                  (res) => {
                      
                  //  alert(JSON.stringify(res));
                  //  alert(res.question);
                  this.setState({
                      query: res
                    });
                  })
                  
                  fetch("http://localhost:8080/studentbyid?user_id="+(sessionStorage.getItem("student_id")),{method:'post'})
          .then(response=> response.json())
        .then(
              (result) => {
               debugger
                this.setState({
                  students: result["s_id"]
                });
                //alert("State of student -"+this.state.students)
              })
      }

      submitQuery = () =>{
          let questionText = this.refs.question.value;
        //  alert("method call");
         

       /* this.setState({
          querySubmit:{
            question:questionText,
            answer:null,
            subject_id:this.state.selectSubValue,
            s_id:this.state.students
          }
        });*/
        let lobjQuery={qtext: questionText,subject_id: this.state.selectSubValue,student_id: this.state.students}
        const requestOptions = {
          method: 'POST',
          headers:{
            'Content-Type':'application/json'
          },
          body: JSON.stringify(
            // qtext: questionText,
            //  subject_id: this.state.onesub,
            //  student_id: this.state.students
            // this.state.querySubmit
            lobjQuery
          ),
         
        }
      //  alert("sub id : "+this.state.subjects.subject_id);
        //alert("stu id : "+this.state.students);
        //alert(" requset "+requestOptions);
          fetch("http://localhost:8080/insertquery",requestOptions);
     alert("inserted")
        .then(response=> response.json())
        
        .then(
            (data) => {
                
             alert(JSON.stringify(data));
             alert(data.question);
            this.setState({
                query: data
              });
            })
      }

      handleChange(e){
        this.setState({selectSubValue:e.target.value});
      //  alert("set t value : "+ this.state.selectSubValue);
      };
    render(){
        const {query} = this.state;
        return(
            <div className="container-fuild" >
                
                <form className="form-group" onSubmit={this.submitQuery}>
                <table className="table table-hover, table-bordered">
                    
                    <tr>
                        <td colspan="2" style={{fontSize:"25px",fontWeight : "bold",textAlign:"center"}}>  Raise Query</td>
                    </tr>
                   
                    <tr>
                        <td style={{fontSize:"20px"}}>Select Subject</td>
                        <td>
                        <select name="subject" ref="subjects" className="form-control" value={this.state.selectSubValue} 
        onChange={this.handleChange} >
                               
                                     {
                                         
                                         this.state.subjects.map(s=>
                                             { return(
                                                  <option value={s.subject_id}>{s.subject_name}</option>
                                              )  }
                                         )
                                     }
                                 </select>
                        </td>
                        <div>Selected value is : {this.state.selectSubValue}</div>
                    </tr>                   
                    <tr>
                        <td style={{fontSize:"20px"}}>Write your Query</td>
                        <td> <input type="text" ref="question" className="form-control"/></td>
                    </tr>
                    <tr> 
                        <td colspan="2"><input type="submit" className="btn btn-block btn-primary"  value="Submit"/></td>
                    </tr>                    
                </table>
                </form>  
                              
                <br/> 
                <table className="table table-hover, table-bordered">
                    <tr>
                        <td style={{fontSize:"20px",fontWeight:"bold"}}>Query</td>
                        <td style={{fontSize:"20px",fontWeight:"bold"}}>Answer</td>
                        
                    </tr>
                    {
              this.state.query.map(q=> (
                <tr key={q.query_id}>
                  <td>{q.question}</td>
                  <td>{q.answer}</td>
                  
                </tr>
              ))}
                   
                </table>               
            </div>
        );
    }
}

export default RaiseQuery;