import React from 'react';
import AttendanceStudent from './AttendanceStudent';
import AttendanceTeacher from './AttrendaceTeacher';
import { Link, Redirect, Route } from 'react-router-dom';
import ReactSession from 'react-client-session';
import RaiseQuery from './RaiseQuery.js';
import ViewStudyMaterial from './ViewStudyMaterial';
import ProgressStudent from './ProgressStudent.js';
class StudentHome extends React.Component{
    constructor(props){
        super(props);
        this.state = { 
            student :[],
            
            loginerror : "",
    };
    }
    
    componentDidMount = () =>
    {
      
        this.setState({student: sessionStorage.getItem("student_id")});
       // alert(sessionStorage.getItem("student_id"));
        const url = "http://localhost:8080/studentById?userid="+sessionStorage.getItem("student_id");
        fetch(url)
        
        .then(response => response.json())
        
        .then(
            (result) => {
             // alert(JSON.stringify(result))
              sessionStorage.setItem("s_id",result.s_id);
              //alert(result);
              //alert("sid : "+ result.s_id);
            },
            (loginerror) => {
              this.setState({ loginerror });
            }
          )
       

    }

    render(){
       
        return(
        <div className="container-fluid">
           
             <h1>Student Home Page</h1> 
             <h4>Welcome {this.state.student}</h4>
             <div className="row">
                <div className="col-md-4">
                    <div>
                     <nav>
                            <Link to={"/studenthome/"+(this.state.student)+"/studymaterial"} >View Study Material</Link><br/>
                            <Link to={"/studenthome/"+(this.state.student)+"/attendance"} >Check Attendance</Link><br/>
                            <Link to={"/studenthome/"+(this.state.student)+"/progressreport"} >View Progress Report</Link><br/>
                            <Link to={"/studenthome/"+(this.state.student)+"/raisequery"} >Raise Query</Link><br/>
                     </nav>
                     </div>
                 </div>
                    
                        
                <div className="col-md-8">
                     <Route path={"/studenthome/"+(this.state.student)+"/studymaterial"} component={ViewStudyMaterial} />
                     <Route path={"/studenthome/"+(this.state.student)+"/attendance"} component={AttendanceStudent} />
                     <Route path={"/studenthome/"+(this.state.student)+"/progressreport"} component={ProgressStudent} />
                    <Route path={"/studenthome/"+(this.state.student)+"/raisequery"}  component={RaiseQuery} />
                 </div>
                   
                    </div>
                </div>
               
            
           
        );
           
    }
}

export default StudentHome;