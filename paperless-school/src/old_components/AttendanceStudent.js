import  Select from 'react-select';
import React from 'react';
import Dropdown from 'react-dropdown';
import StudentHome from './StudentHome';

 
class AttendanceStudent extends React.Component{
    constructor(props)
    {
        super(props);
        this.state = { 
            msg : "",
            loginerror : "",
            student : [],
            isDisabled : true,
            at_data : null,
            at_remark : null,
            att : [{month :"",working_days:"",present_days:""}],
            selectClassValue : "",
            selectedOption: null
         }
         this.handleClassChange = this.handleClassChange.bind(this);
    }
    
    checkAttendance = () =>{
       
        this.setState({student: sessionStorage.getItem("student_id")});
        alert(sessionStorage.getItem("student_id"));
       // alert(this.student);
        const url="http://localhost:8080/attendance?user_id="+sessionStorage.getItem("student_id")+"&month="+(this.state.selectClassValue);
       // const url="http://localhost:8080/attendance?studentid=2021001&month=6";
         fetch(url,{method:'post'})
         .then(res => res.json())
         .then(result => {
                 alert(JSON.stringify(result))
                  this.setState({at_data: result})
                 
             });
        

             const url1="http://localhost:8080/remark?user_id="+sessionStorage.getItem("student_id")+"&month="+(this.state.selectClassValue);
       // const url="http://localhost:8080/attendance?studentid=2021001&month=6";
         fetch(url1,{method:'post'})
         .then(res => res.json())
         .then(data => {
                 alert(JSON.stringify(data))
                  this.setState({at_remark: data})
                 
             });

     }
   

     handleClassChange(e){
        this.setState({selectClassValue:e.target.value});
        alert("set class value : "+ this.state.selectClassValue);
      };
 render(){
        return(
            <div className="container-fuild" >
                
                <form className="form-group">
                <table className="table table-striped, table-border">
                    <tr>
                        <td>Select Month</td>
                        <td>
                        <select name="month"  className="form-control" value={this.state.selectClassValue}
        onChange={this.handleClassChange}>
                                                <option>Select Month</option>
                                                <option value="01">Jan</option>
                                                <option value="02">Feb</option>
                                                <option value="03">Mar</option>
                                                <option value="04">Apr</option>
                                                <option value="05">May</option>
                                                <option value="06">June</option>
                                                <option value="07">July</option>
                                 </select>
                        </td>
                       
                    </tr>
                    <tr> 
                        <td colspan="2"><input type="button" className="btn btn-block btn-primary" onClick={this.checkAttendance} value="Submit Month"/></td>
                    </tr>
                    </table>
                    <div id="attedance" style={{display:"block"}}>
                    <table  className="table table-striped, table-border">
                    <tr><td colspan="2" style={{fontSize:"25px",fontWeight : "bold",textAlign:"center"}}>  Attendance Report</td></tr>
                   <tr>
                       <td> Month  </td>
                       <td> Present Days </td>
                       <td> Working Days </td>
                      
                    </tr>
                    <tr>
                        <td> {this.state.selectClassValue}</td>
                        <td> {this.state.at_remark}  </td>
                        <td>{this.state.at_data} </td>
                               
                    </tr>
                   
                    
                </table>
                </div>
                </form>
                
                <br/>
                
            </div>
        );
    }
}

export default AttendanceStudent;