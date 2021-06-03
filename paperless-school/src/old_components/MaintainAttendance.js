import React from 'react';
import Select from 'react-select';
const classes = [
    { label: "I", value: 1 },
    { label: "II", value: 2 },
    { label: "III", value: 3 },
    { label: "IV", value: 4 },
    { label: "V", value: 5 },

];

class MaintainAttendance extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            msg: "",
            loginerror: "",
            students: [{ "s_id": null, "user_id": null, "first_name": null, "middle_name": null, "last_name": null, "email": null, "contact_no": null, "address": null, "dob": null, "class_id": null }],
            attendanceReport:[{"date":null,"remark":null,"s_id":null,"student_name":null}]
        }
        this.handleRemarkChange = this.handleRemarkChange.bind(this);
    }

    componentDidMount = () => {
        //  alert("tid : "+sessionStorage.getItem("teacher_id"));
        fetch("http://localhost:8080/studlist?user_id=" + sessionStorage.getItem("teacher_id"))
            .then(response => response.json())
            .then(data => {
                debugger;
                var lStudentData= data;
                var lattendanceReport=[];
                for(var lobj in lStudentData){
                    debugger;
                    lattendanceReport.push(
                        {"date":null,"remark":null,"s_id":lStudentData[lobj]["s_id"],"student_name":lStudentData[lobj]["first_name"]+" "+lStudentData[lobj]["last_name"]}
                    )
                }
                this.setState({attendanceReport:lattendanceReport});
                this.setState({ students: data })
            });
    }

    insertAttendence = () =>
    {
        debugger;
    console.log(this.state.attendanceReport);
    const requestOptions = {
    method: 'POST',
    headers:{
      'Content-Type':'application/json'
    },
    body: JSON.stringify(
     
      this.state.attendanceReport
    ), 
  }
  fetch("http://localhost:8080/insertAttendance",requestOptions);
    alert("Attendance inserted successfully")

    }

    handleRemarkChange = i => e =>{
        // this.setState({selectChapterValue:e.target.value});
        const { name, value } = e.target;
    const attendanceReport = [...this.state.attendanceReport];
    // attendanceReport[i] = { [name]: value };
    attendanceReport[i][name] = value;
    this.setState({ attendanceReport });

        //alert("set chapter value : "+ this.state.selectChapterValue);
      };
      
    render() {
        return (
            <div className="container-fuild" >

                <form className="form-group">

                    <table className="table table-hover, table-bordered">
                        <tr>
                            <th>Student Name</th>
                            <th>Attendance date</th>
                            <th>Remark</th>
                        </tr>
                        {

                            this.state.attendanceReport.map((t,i) => {
                                return (
                                    <tr>
                                         
                                         <td>{t.student_name}</td>
                                         <td><input idKey={`${i}`} value={t.date} type="date" name="date" className="form-control" onChange={this.handleRemarkChange(i)} /></td>
                                         {/* <td><input value={t.remark} type="text" ref="remarktext" placeholder="Remark" className="form-control" onChange={this.handleRemarkChange} /></td> */}
                                         {/* <td><input idKey={`${i}`} value={this.state.attendanceReport[i]["remark"]} type="text" name={`${i}_remark`} 
                                         placeholder="Remark" className="form-control" onChange={this.handleRemarkChange(i)} /></td> */}

                                        <td><input value={t.remark} type="text" name="remark" placeholder="Remark" className="form-control" onChange={this.handleRemarkChange(i)} /></td>
                                    </tr>
                                   
                                )
                            }
                            )
                        }
                        <tr>
                            <td colspan="3"><input type="submit" className="btn btn-block btn-primary" onClick={this.insertAttendence} value="Submit" /></td>
                        </tr>
                    </table>
                    
                </form>

                <br />

            </div>
        );
    }
}

export default MaintainAttendance;