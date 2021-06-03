
import React, { Component } from 'react';


class AllTeachers extends React.Component{

    constructor(props){
        super(props);
        this.state = {
          
            teachers: []
          }
    }

    componentDidMount=()=>{
      fetch("http://localhost:8080/allteacherdata")
      .then(response=> response.json())
      .then(data => this.setState({teachers: data}));
      }

    render(){
       
      return(
        <div>
          <h2 style={{textAlign:"center"}}>Teacher Details</h2>
          <table border="1" className="table table-hover table-bordered">
            <thead>
              <tr>
                <th>Teacher Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Qualifications</th>
                <th>Email</th>
              </tr>
            </thead>
            <tbody>
              {
              this.state.teachers.map(teacher=> (
                <tr key={teacher.t_id}>
                  <td>{teacher.t_id}</td>
                  <td>{teacher.first_name}</td>
                  <td>{teacher.last_name}</td>
                  <td>{teacher.qualification}</td>
                  <td>{teacher.email}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )
    
    }
}

export default AllTeachers;