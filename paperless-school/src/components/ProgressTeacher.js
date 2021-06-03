
import React from 'react';
import { Label } from '@material-ui/icons';
import  Select from 'react-select';
import { Link, Route } from 'react-router-dom';
import '../style.css';
const classes = [
    {label : "I", value:1},
    {label : "II", value:2},
    {label : "III", value:3},
    {label : "IV", value:4},
    {label : "V", value:5},
  
  ];
class ProgressTeacher extends React.Component{
  constructor(props)
    {
        super(props);
        this.state = { 
           students:[],
           subjects: [],
           progressReport:[{"out_of_marks":null,"obtain_marks":null,"subject_id":null,"progress_id":null}],
         //  selectSubValue : 0,
           selectStudentValue : 0,
           selectedOption: null,
           subjectDetails:{}
         }
         this.handleStudentChange = this.handleStudentChange.bind(this);
         this.getSubjectName = this.getSubjectName.bind(this);

    }

    componentDidMount =() =>
    {
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

    handleRemarkChange = i => e =>{
        debugger;
        const { name, value } = e.target;
        const lprogreport = [...this.state.progressReport];
        lprogreport[i][name] = value;
        this.setState({ lprogreport });
       
      };

      handleStudentChange(e){
        this.setState({selectStudentValue: e.target.value});
        
    }
    getSubjectName(subjectindex) {
        if(this.state.subjectDetails[subjectindex])
            return this.state.subjectDetails[subjectindex]["subject_name"];
        return "";
    }  
    generateProgress =() =>
    {
        fetch("http://localhost:8080/selectsubject?user_id="+sessionStorage.getItem("teacher_id"),{method:'post'})
        .then(response=> response.json())
        .then(
            (result) => {
              //  alert(JSON.stringify(result));
                var lsubject = result;
                //alert(JSON.stringify(lsubject));
                var lsubjectmarks=[];
                for(var lobj in lsubject){
                    debugger;
                    lsubjectmarks.push(
                        //{"date":null,"remark":null,"s_id":lStudentData[lobj]["s_id"],"student_name":lStudentData[lobj]["first_name"]+" "+lStudentData[lobj]["last_name"]}
                        {"out_of_marks":lsubject[lobj]["out_of_marks"],"obtain_marks":lsubject[lobj]["obtain_marks"],"subject_id":lsubject[lobj]["subject_id"],"progress_id":this.state.selectStudentValue}
                    )          
                }
                this.setState({progressReport:lsubjectmarks});
                this.setState({subjectDetails:result});
            }) 
    }

    submitMarks = () =>
    {
        debugger;
    console.log(this.state.progressReport);
    const requestOptions = {
    method: 'POST',
    headers:{
      'Content-Type':'application/json'
    },
    body: JSON.stringify(
     
      this.state.lprogreport,
     // alert(this.state.lprogreport)
    ), 
  }

  fetch("http://localhost:8080/insertMarks",requestOptions);
   alert("marks inserted/updated successfully");
}

    
    render()
    {  
        return(
          <div className="container-fuild" >
                
                <form className="form-group">
                <table className="table table-hover, table-bordered">
                   
                    <tr>
                        <td  style={{fontSize:"20px",fontWeight : "bold"}}>Select Student </td>
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
                        <td colspan="2"><input type="button" className="btn btn-block btn-primary" onClick={this.generateProgress} value="Generate Progress Report"/></td>
                    </tr>
                    
                </table>

                <table className="table table-hover, table-bordered">
                        <tr>
                            <th>Subject Name</th>
                            <th>Out of Marks</th>
                            <th>Obtain Marks</th>
                        </tr>
                        { 

           this.state.progressReport.map((t,i) => {
    return (
        <tr>
             
             <td>{this.getSubjectName(`${i}`) }</td>
             <td><input idKey={`${i}`} value={t.out_of_marks} type="text" name="out_of_marks" className="form-control" onChange={this.handleRemarkChange(i)} /></td>
             {/* <td><input value={t.remark} type="text" ref="remarktext" placeholder="Remark" className="form-control" onChange={this.handleRemarkChange} /></td> */}
             {/* <td><input idKey={`${i}`} value={this.state.attendanceReport[i]["remark"]} type="text" name={`${i}_remark`} 
             placeholder="Remark" className="form-control" onChange={this.handleRemarkChange(i)} /></td> */}

            <td><input value={t.obtain_marks} type="text" name="obtain_marks" placeholder="" className="form-control" onChange={this.handleRemarkChange(i)} /></td>
        </tr>
       
    )
}
)
}
                        <tr>
                            <td colspan="3"><input type="button" className="btn btn-block btn-primary" onClick={this.submitMarks} value="Submit Marks" /></td>
                        </tr>
                        
                    </table>
                </form>
                
                <br/>
                
            </div>      
            
        );
    }
  }

export default ProgressTeacher;