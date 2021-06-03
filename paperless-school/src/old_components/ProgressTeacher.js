
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
            msg : "",
            loginerror : "",
            students : [],
            subjects : [],
            onestudent : []
         }
    }
    componentDidMount = () =>
    {
        alert("tid : "+sessionStorage.getItem("teacher_id"));
        
        fetch("http://localhost:8080/studlist?user_id="+sessionStorage.getItem("teacher_id"))
        .then(response=> response.json())
        .then(data => this.setState({students: data}));


        fetch("http://localhost:8080/selectsubject?user_id="+sessionStorage.getItem("teacher_id"),{method : "post"})
        .then(resp => resp.json())
        .then(data =>{
            alert(JSON.stringify(data))
           this.setState({subjects: data})
         } );
       
    }
    showStudMarks = () =>
    {
        const url = "http://localhost:8080/studentById?userid="+sessionStorage.getItem("student_id");
        fetch(url)
        
        .then(response => response.json())
        
        .then(
            (result) => {
              alert(JSON.stringify(result))
              this.setState({
                  onestudent : []
              })
            })
    }
   /* showSubjects = () =>
    {
        fetch("http://localhost:8080/selectsubject?user_id="+sessionStorage.getItem("t_id"))
        .then(resp => resp.json())
        .then(data =>
         
           this.setState({subjects: data})
           );
       
    }*/

    render()
    {  

        return(
          <div className="container-fuild" >
                
                <form className="form-group" onSubmit={this.showStudMarks}>
                <table className="table table-hover, table-bordered">
                   
                    <tr>
                        <td style={{fontSize:"20px"}}>Select Student</td>
                        <td>
                        <select name="student" className="form-control" >
                                <option value="select">Select Student</option>
                                     {
                                         
                                         this.state.students.map(t=>
                                             { return(
                                                  <option value={t.s_id}> {t.first_name} {t.last_name}</option>
                                              )  }
                                         )
                                     }
                                 </select> 
                        </td>
                    </tr>
                    <tr> 
                        <td colspan="2"><input type="submit" class="createBtn"  value="Show Student Progress"/></td>
                    </tr>
                    </table>
                    </form >
                    <br/>
                    <div>
                    <form className="form-group" onSubmit={this.submitMarks}>
                    <table className="table table-hover, table-bordered">
                    <tr>
                        <td colspan="3" style={{fontSize:"25px",fontWeight : "bold",textAlign:"center"}}> Progress Report</td>
                    </tr>
                   <tr>
                       <td style={{fontSize:"20px"}}> Subject </td>
                       <td style={{fontSize:"20px"}}> Total Marks</td>
                       <td style={{fontSize:"20px"}}> Obtain Marks</td>
                       
                      
                    </tr>
                    <tbody>
                        
            
            {
              
              this.state.subjects.map(s=> { return(
                 <tr>
                  
                  <td>{s.subject_name}</td>
                  <td>100</td>
                  <td><input type="text" placeholder="Obtain Marks"/></td> 
                 </tr>
                 
              )})
             }
             </tbody>
             <tr> 
                        <td colspan="3"><input type="submit" class="createBtn"  value="Submit Marks"/></td>
                    </tr> 
                </table>
                </form>
                </div>
                <br/>
                
            </div>      
            
        );
    }
  }

export default ProgressTeacher;