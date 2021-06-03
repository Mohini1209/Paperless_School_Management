import React, { Component } from 'react';


class ProgressStudent extends React.Component{

    constructor(props){
        super(props);
        this.state = {
          
            sub_marks: [],
           
            comment:""
          }
    }

    componentDidMount=()=>{

      fetch("http://localhost:8080/stumarks?sid="+sessionStorage.getItem("s_id"))
      .then(resp => resp.json())
      .then(data => this.setState({sub_marks: data, comment: data[0].progress_id.comment}));
     
      }

     

    render(){
       
       const {comment} = this.state.comment;
      return(
        <div className="border border-dark">
          <br/>
          <h2 style={{textAlign:"center",color:"#888888"}}>Wisdom Public School</h2>
          <h3 style={{textAlign:"center",color:"#505050"}}>Progress Report</h3>
          <br/>
         
           <table border="1" className="table table-hover table-bordered">
            <thead>
              <tr border="1" style={{textAlign:"center"}}>
                <th>Sr.No.</th>
                <th>Subject</th>
                <th>Total Marks</th>
                <th>Obtain Marks</th>
              </tr>
            </thead>
            <tbody>
            
            {
              
              this.state.sub_marks.map(s=> { return(
                 <tr style={{textAlign:"center"}}>
                   <td>{s.subject_id.subject_id}</td>
                  <td>{s.subject_id.subject_name}</td>
                  <td>{s.out_of_marks}</td>
                  <td>{s.obtain_marks}</td> 
                 </tr>
                 
              )})
             }
             
               
            </tbody>
                      
          </table><br/>
           <p> &emsp;Your Child Progress Report is <b>{this.state.comment}</b>. If you have any questions or concerns please contact us.</p>
          <br/>
         
          <p>&emsp;School Reopens on - 26th June 2021<i>(Tentitive date)</i></p>
          <div></div>
          <br/>
          
          <table>
            <tr>
              <td><img src="/images/tsign.png" height="80px" width="125px"/></td>
              <td><img src="/images/psign1.jpg"height="80px" width="125px"/></td>
              <td></td>
            </tr>
              <tr>
                  <td style={{width:1300}}><h5><b>&emsp;Class Teacher</b></h5></td>
                  <td style={{width:1200}}><h5><b>Head Master</b></h5></td>
                  <td style={{width:600}}><h5><b>Parent's Sign</b></h5></td>
                  <br/>
          <br/><br/>
          <br/>
          <br/><br/>
            </tr>
          </table>
          <h2 style={{textAlign:"center", fontFamily:"cursive",color:"blue"} } >Congratulations</h2>
          <br/><br/>
          <br/>
          
        </div>
      )
    
    }
}

export default ProgressStudent;