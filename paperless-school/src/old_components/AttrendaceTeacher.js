import React from 'react';
import  Select from 'react-select';
const classes = [
    {label : "I", value:1},
    {label : "II", value:2},
    {label : "III", value:3},
    {label : "IV", value:4},
    {label : "V", value:5},
  
  ];

class AttendanceTeacher extends React.Component{
    constructor(props)
    {
        super(props);
        this.state = { 
            msg : "",
            loginerror : "",
            students : []
         }
    }
    
    componentDidMount = () =>
    {
        alert("tid : "+sessionStorage.getItem("teacher_id"));
        
        fetch("http://localhost:8080/studlist?user_id="+sessionStorage.getItem("teacher_id"))
        .then(response=> response.json())
        .then(data => this.setState({students: data}));
    }

    render(){
        return(
            <div className="container-fuild" >
                
                <form className="form-group">
                <table className="table table-hover, table-bordered">
                    <tr>
                        <td style={{fontSize:"20px"}}>Enter Date</td>
                        <td> <input type="date" ref="text" className="form-control"/></td>
                    </tr>
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
                        <td style={{fontSize:"20px"}}>Enter Remark (P/A)</td>
                        <td> <input type="text" ref="text" className="form-control"/></td>
                    </tr>
                    <tr> 
                        <td colspan="2"><input type="button" className="btn btn-block btn-primary" onClick={this.checkLogin} value="Submit"/></td>
                    </tr>
                    <tr>
                        <td colspan="2" style={{fontSize:"25px",fontWeight : "bold",textAlign:"center"}}>  Attendance Report</td>
                    </tr>
                   <tr>
                       <td style={{fontSize:"20px"}}> Months  </td>
                       <td style={{fontSize:"20px"}}> Total Present Days  </td>
                       <td style={{fontSize:"20px"}}> Total Working Days  </td>
                      
                    </tr>
                    <tr>
                      
                        <td><input type="text" ref="text" className="form-control"/></td>
                        <td> <input type="text" ref="text" className="form-control"/></td>
                        <td> <input type="text" ref="text" className="form-control"/></td>
                    </tr>
                   
                    
                </table>
                </form>
                
                <br/>
                
            </div>
        );
    }
}

export default AttendanceTeacher;