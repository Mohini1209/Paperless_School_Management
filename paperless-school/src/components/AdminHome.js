import React from 'react';
import CreateStudentAccount from './CreateStudentAccount.js';
import CreateTeacherAccount from './CreateTeacherAccount.js';
import Teacher from './Teacher.js';
import AssignClass from './AssignClass.js';
import AllStudents from './AllStudents.js';
import Std from './Students.js';
import AllTeachers from './AllTeachers.js';
import {Link, Route} from 'react-router-dom';
class AdminHome extends React.Component{
    constructor(props){
        super(props);
        this.state = {
            admin : []
        }
        
    }
    componentDidMount = () =>
    {
       this.setState({admin: sessionStorage.getItem("user_id")});
        const url = "http://localhost:8080/adminhome/user_id="+sessionStorage.getItem("user_id");
        fetch(url)
        .then(res => res.json())
        .then(result => {
           // alert(JSON.stringify(result));
           
        }
      
        );
       
    }

    render(){
        return(
            <div className="container-fluid">
           
            <h1>Admin Home Page</h1> 
            
            <div className="row">
               <div className="col-md-4">
                   <div>
                    <nav>
                           <Link to={"/adminhome/"+(this.state.admin)+"/createstudentaccount"} >Create Student Account</Link><br/>
                           <Link to={"/adminhome/"+(this.state.admin)+"/createteacheraccount"} >Create Teacher Account</Link><br/>
                           <Link to={"/adminhome/"+(this.state.admin)+"/assignclass"} >Assign Class</Link><br/>
                           <Link to={"/adminhome/"+(this.state.admin)+"/allstudents"} >All Students</Link><br/>
                           <Link to={"/adminhome/"+(this.state.admin)+"/allteacherdata"} >All Teachers</Link><br/>
                           
                          
                    </nav>
                    </div>
                </div>
                   
                       
               <div className="col-md-8">
                    <Route path={"/adminhome/"+(this.state.admin)+"/createstudentaccount"} component={CreateStudentAccount} />
                    <Route path={"/adminhome/"+(this.state.admin)+"/createteacheraccount"} component={CreateTeacherAccount} />
                    <Route path={"/adminhome/"+(this.state.admin)+"/assignclass"} component={AssignClass} />
                    <Route path={"/adminhome/"+(this.state.admin)+"/allstudents"} component={AllStudents} />
                    <Route path={"/adminhome/"+(this.state.admin)+"/allteacherdata"} component={AllTeachers} />
                    
                </div>
                  
                   </div>
               </div>
             
        );
    }
}

export default AdminHome;