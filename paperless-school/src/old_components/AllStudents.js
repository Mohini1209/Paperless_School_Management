
import React, { Component } from 'react';


class AllStudents extends React.Component{

    constructor(props){
        super(props);
        this.state = {
            error: null,
            students: []
          }
    }

    componentDidMount() {
        const apiUrl = 'http://localhost:8080/allstudents';
    
        fetch(apiUrl)
          .then(res => res.json())
          .then(
            (result) => {
              alert(JSON.stringify(result));
              this.setState({
                students: result
              });
            },
            (error) => {
              this.setState({ error });
            }
          )
      }
    render(){
        const { error, students} = this.state;
       

    if(error) {
      return (
        <div>Error: {error.message}</div>
      )
    } else {
      return(
        <div>
          <h2 style={{textAlign:"center"}}>Student Details</h2>
          <table  className="table table-hover table-bordered">
            <thead>
              <tr>
                <th>Student Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
              </tr>
            </thead>
            <tbody>
              
              {students.map(student=> (
                <tr key={student.student_id}>
                  <td>{student.user_id.user_id}</td>
                  <td>{student.first_name}</td>
                  <td>{student.last_name}</td>
                  <td>{student.email}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )
    }
    }
}

export default AllStudents;