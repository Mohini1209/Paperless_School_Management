import React from 'react';
import ReactDOM from 'react-dom';
import  Select from 'react-select';
//import '../index.css';
//import 'bootstrap/dist/css/bootstrap.min.css';

import AllQueries from './AllQueries.js';



const classes = [
    {label : "I", value:1},
    {label : "II", value:2},
    {label : "III", value:3},
    {label : "IV", value:4},
    {label : "V", value:5},
  
  ];

  
  const subjects = [
    {label : "Maths", value:1},
    {label : "English", value:2},
    {label : "Marathi", value:3},
    {label : "Environment", value:3},
    {label : "History", value:3},
    {label : "GK", value:3},
    
  ]


class AnswerQuery extends React.Component{
    constructor(props)
      {
          super(props);
          this.state = { 
              msg : "",
              loginerror : "",
              subjects : [],
              queries : [],
              selectSubValue : 0,
          selectClassValue : 0,
          selectedOption: null
        }
        this.handleSubChange = this.handleSubChange.bind(this);
        this.handleClassChange = this.handleClassChange.bind(this); 
      }
      componentDidMount=()=>{
        fetch("http://localhost:8080/selectsubject?user_id="+sessionStorage.getItem("teacher_id"),{method:'post'})
       .then(response=> response.json())
       .then(
           (result) => {
               alert("subjects")
            alert(JSON.stringify(result));
           this.setState({
               subjects: result
             });
           })
         
           fetch("http://localhost:8080/allqueries?subject_id=101&user_id="+sessionStorage.getItem("teacher_id"))
           .then(response=> response.json())
           .then(
               (res) => {
                   alert("queries")
                alert(JSON.stringify(res));
               this.setState({
                   queries: res
                 })
               })

          
    }
   /* showAllQueries = (e) =>
    {
        fetch("http://localhost:8080/allqueries?subject_id=101&t_id=1")
       .then(response=> response.json())
       .then(
           (result) => {
            alert(JSON.stringify(result));
           this.setState({
               queries: result
             });
           })
    }*/
    handleSubChange(e){
        
        this.setState({selectSubValue : e.target.value});
        alert(e.target.value)
    }
    handleClassChange(e){
        this.setState({selectClassValue:e.target.value});
        alert("set class value : "+ this.state.selectClassValue);
      };
      render()
      {  
        const {subjects} = this.state.subjects;
          return(
            <div className="container-fuild" >
                  
                  <form className="form-group" onSubmit={this.showAllQueries}>
                  <table className="table table-hover, table-bordered">
                      <tr>
                          <td style={{fontSize:"20px"}}>Select Class</td>
                          <td>
                          <select name="class"  className="form-control" value={this.state.selectClassValue}
        onChange={this.handleClassChange}> 
                                                <option value="select">Select Class</option>
                                                <option value="10">I</option>
                                                <option value="20">II</option>
                                                <option value="30">III</option>
                                                <option value="40">IV</option>
                                                <option value="50">V</option>
                                     
                                 </select>
                          </td>
                          <td>{this.state.selectClassValue}</td>
                      </tr>
                      <tr>
                          <td style={{fontSize:"20px"}}>Select Subject</td>
                          <td>
                          <select name="subject" ref="subjects" className="form-control"  value={this.state.selectSubValue}
        onChange={this.handleSubChange} >
                               
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
                          <td colspan="2"><input type="submit" className="btn btn-block btn-primary" onClick={this.checkLogin} value="Show Queries"/></td>
                      </tr>

                      </table><br/>
                      <h3>All Queries</h3>
                      <table  className="table table-hover, table-bordered">

                     <thead>
                     <tr>
                         <td style={{fontSize:"20px"}}> StudentID</td>
                         <td style={{fontSize:"20px"}}> Queries</td>
                         <td style={{fontSize:"20px"}}> Answer</td>
                         
                        
                        
                      </tr>
                      </thead>
                      <tbody>
                      {
              this.state.queries.map(q=> (
                <tr key={q.query_id}>
                  <td>{q.s_id.user_id}</td>
                  <td>{q.question}</td>
                  <td>{q.answer}</td>
                 
                </tr>
              ))}
              </tbody>
                   
                      
                  </table>
                  </form>
                  
                  <br/>
                  
              </div>      
              
          );
      }
    }



export default AnswerQuery;
