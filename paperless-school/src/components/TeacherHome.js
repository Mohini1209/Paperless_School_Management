import React from 'react';
import MaintainAttendance from './MaintainAttendance.js';
import AttendanceStudent from './AttendanceStudent';
import UploadStudyMaterial from './UploadStudyMaterial.js';
import ProgressTeacher from './ProgressTeacher.js';
import { Link, Redirect, Route } from 'react-router-dom';
import ReactSession from 'react-client-session';
import AnswerQuery from './AnswerQuery.js';
class TeacherHome extends React.Component{
    constructor(props){
        super(props);
        this.state = { 
            teacher :[],
            
            loginerror : "",
    };
    }

    componentDidMount = () =>
    {
       // const url = "http://localhost:8080/checkStudent?student_id="+user_id;
        //fetch(url)
       
        this.setState({teacher: sessionStorage.getItem("teacher_id")});
        //alert(sessionStorage.getItem("teacher_id"));
        const url = "http://localhost:8080/teacherById?user_id="+sessionStorage.getItem("teacher_id");
        fetch(url,{method:'post'})

        .then(response => response.json())
        
        .then(
            (result) => {
              sessionStorage.setItem("t_id",result.t_id);
              
            },
            (loginerror) => {
              this.setState({ loginerror });
            }
          )
       
    }


    render(){
        return(
            <div className="container-fluid">
            
             <h1>Teacher Home Page</h1> 
             <h4>Welcome </h4>
             <div className="row">
                <div className="col-md-4">
                    <div>
                     <nav>
                            <Link to={"/teacherhome/"+(this.state.teacher)+"/studymaterial"} >Upload Study Materials</Link><br/>
                            <Link to={"/teacherhome/"+(this.state.teacher)+"/progressreport"} >Generate Progress Report</Link><br/>
                            <Link to={"/teacherhome/"+(this.state.teacher)+"/attendance"} >Maintain Attendence</Link><br/>
                            <Link to={"/teacherhome/"+(this.state.teacher)+"/answerqueries"} >Answer Queries</Link><br/>
                     </nav>
                     </div>
                 </div>
                    
                        
                <div className="col-md-8">
                     <Route path={"/teacherhome/"+(this.state.teacher)+"/studymaterial"} component={UploadStudyMaterial} />
                     <Route path={"/teacherhome/"+(this.state.teacher)+"/progressreport"} component={ProgressTeacher} />
                     <Route path={"/teacherhome/"+(this.state.teacher)+"/attendance"} component={MaintainAttendance} />
                    <Route path={"/teacherhome/"+(this.state.teacher)+"/answerqueries"}  component={AnswerQuery} />
                 </div>
                   
                    </div>
                
           
        </div>
        );
    }
}

export default TeacherHome;