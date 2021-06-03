
import React from 'react';
import { Label } from '@material-ui/icons';
import '../style.css';
import ReactSession from 'react-client-session';
class Login extends React.Component{
    constructor(props)
    {
        super(props);
        this.state = { 
            msg : "",
            loginerror : ""
         }
    }
    checkLogin = () => {
        let user_id = this.refs.user_id.value;
        let password = this.refs.password.value;

        const url = "http://localhost:8080/checkLogin?user_id="+user_id+"&password="+password;
        fetch(url)
        .then(response => response.text())
        .then(data => {
            if(data == "Student")
            {
                sessionStorage.setItem("student_id",user_id);
                this.props.history.push("/studenthome/"+user_id);
            }
            else if(data == "Teacher")
            {
                sessionStorage.setItem("teacher_id",user_id);
                this.props.history.push("/teacherhome/"+user_id);
            }
            else if(data == "Admin")
            {
                sessionStorage.setItem("user_id",user_id);
                this.props.history.push("/adminhome/"+user_id);
            }
            else if(data == "")
            {
                this.setState({loginerror: "Wrong ID or Password"});
                
            }
        });
    }

    render(){
        
        return(
            
            <div className="container" style={{backgroundImage:"url(/images/background.jpeg)"}}>
                <br/><br/><br/><br/><br/><br/>
                <div className="row">
                <div className="col-md-6"></div>
                <div className="col-md-6">
                <form className="form-group">
                    
                   <table className="table table-striped">
                    <tr><td colspan="2" style={{fontSize:"30px",fontWeight : "bold",textAlign:"center"}}>Login </td></tr>
                   <tr>
                       <td style={{fontSize:"25px"}}><label for="user_id">User ID </label>  </td>
                       <td><input type="text" ref="user_id" className="form-control"/></td>
                    </tr>
                    <tr>
                        <td style={{fontSize:"25px"}}><label for="password"> Password  </label> </td>
                        <td> <input type="password" ref="password" className="form-control"/></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="button" class="commonBtn" onClick={this.checkLogin} value="Login"/></td>
                    </tr>
                 <tr><td colspan="2" style={{color:"red",textAlign:"center",fontSize:"25px"}}>{this.state.loginerror}</td></tr>
                 <br/>
                </table>
                </form>
                </div>
                </div>
                <br/>
                
            </div>
        );
    }
}

export default Login;