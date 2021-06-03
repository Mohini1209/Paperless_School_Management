
import React, { Component } from 'react';
import axios from 'axios';

class CreateStudentAccount extends React.Component{

    constructor(props){
        super(props);
        this.state = {
            user_id : '',
			first_name:'',
            middle_name : '',
            last_name:'',
            email:'',
            contact_no:'',
            address:'',
            dob : '',
            class_id : '',
             password:'',
            
		}
    }

    changeHandler = e => {
		this.setState({ [e.target.name]: e.target.value })
	}

	registerStudent = e => {
		e.preventDefault()
		console.log(this.state)
		axios
			.post('http://localhost:8080/insertstudent', this.state)
			.then(response => {
				console.log(response)
			})
			.catch(error => {
				console.log(error)
			})
	}
    submitData = () =>
    {
        alert("Registration Successful....!!");
    }
    render(){
        const {
            user_id,
         first_name,
         middle_name,
        last_name,
        email,
        contact_no,
        address,
        dob,
        class_id,
        password } = this.state
        return(
            <div className="container" style={{backgroundImage:"url(/images/student1.jpeg)"}}>
            <br/><br/>
            <div className="row">
            
            <div className="col-md-12">
						<form onSubmit={this.registerStudent} >
						<table className="table table-striped table-bordered">
						<tr><td colspan="2" style={{fontSize:"30px",fontWeight : "bold",textAlign:"center"}}> Student Registration</td></tr>
								<tr>
								<td style={{fontSize:"20px",textAlign:"center"}}><label for="user_id"> User Id </label> 
								</td>
									<td>
									
                    
					<input
					className="form-control"
						type="text"
						name="user_id"
						value={user_id}
						placeholder="User Id"
						onChange={this.changeHandler}
					/>
			
									</td>
								</tr>
							
								<tr>
								<td style={{fontSize:"20px",textAlign:"center"}}><label for="first_name"> First Name </label> 
								</td>
									<td>
									
					<input
					className="form-control"
						type="text"
						name="first_name"
						value={first_name}
						placeholder="First Name"
						onChange={this.changeHandler}
					/>
				
									</td>
								</tr>
                                <tr>
								<td style={{fontSize:"20px",textAlign:"center"}}><label for="middle_name"> Middle Name </label> 
								</td>
									<td>
									
					<input
					className="form-control"
						type="text"
						name="middle_name"
						value={middle_name}
						placeholder="Middle Name"
						onChange={this.changeHandler}
					/>
				
									</td>
								</tr>
							
								<tr>
								<td style={{fontSize:"20px",textAlign:"center"}}><label for="last_name"> Last Name </label> 
								</td>
									<td>
									
						<input
                        className="form-control"
							type="text"
							name="last_name"
							value={last_name}
                            placeholder="Last Name"
							onChange={this.changeHandler}
						/>
				
									</td>
								</tr>
							
								<tr>
								<td style={{fontSize:"20px",textAlign:"center"}}><label for="email"> Email </label> 
								</td>
									<td>
									
									<input
									className="form-control"
										type="text"
										name="email"
										value={email}
										placeholder="Email"
										onChange={this.changeHandler}
									/>
									</td>
								</tr>
							
								<tr>
								<td style={{fontSize:"20px",textAlign:"center"}}><label for="contact_no"> Contact No </label> 
								</td>
									<td>
								
						<input
                        className="form-control"
							type="text"
							name="contact_no"
							value={contact_no}
                            placeholder="Contact number"
							onChange={this.changeHandler}
						/>
                       
									</td>
								</tr>
                                <tr>
								<td style={{fontSize:"20px",textAlign:"center"}}><label for="address"> Address</label> 
								</td>
									<td>
									
						<input
                        className="form-control"
							type="text"
							name="address"
							value={address}
                            placeholder="Address"
							onChange={this.changeHandler}
						/>
                      
									</td>
								</tr>
								<tr>
								<td style={{fontSize:"20px",textAlign:"center"}}><label for="dob"> Date of Birth</label> 
								</td>
									<td>
									
						<input
                        className="form-control"
							type="date"
							name="dob"
							value={dob}
                            placeholder="Date Of Birth"
							onChange={this.changeHandler}
						/>
                      
									</td>
								</tr>
                                <tr>
								<td style={{fontSize:"20px",textAlign:"center"}}><label for="class_id"> Standard</label> 
								</td>
									<td>
									
						<select
                        className="form-control"
                        placeholder="Standard"
                        onChange={this.changeHandler}
							name="class_id"
							>
                                <option>Select Standard</option>
                                <option value="10">I</option>
                                <option value="20">II</option>
                                <option value="30">III</option>
                                <option value="40">IV</option>
                                <option value="50">V</option>
                           </select>
						
                      
									</td>
								</tr>
								<tr>
								<td style={{fontSize:"20px",textAlign:"center"}}><label for="password"> Password</label> 
								</td>
									<td>
								
						<input
                        className="form-control"
							type="password"
							name="password"
							value={password}
                            placeholder="Password"
							onChange={this.changeHandler}
						/>
                      
									</td>
								</tr>
							
								<tr>
								<td colspan="2"> <button class="createBtn" onClick={this.submitData} type="submit">Submit</button></td>
								</tr>
							
						</table>
               </form>
			
            </div>
            </div>
            <br/>
            
        </div>
        );
    }
}

export default CreateStudentAccount;