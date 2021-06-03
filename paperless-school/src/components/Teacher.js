import React, { Component } from 'react'
import axios from 'axios'
class Teacher extends Component {
	constructor(props) {
		super(props)

		this.state = {
            user_id : '',
			first_name:'',
            last_name:'',
            email:'',
            contact_no:'',
            qualification : '',
            address:'',
             password:'',
		}
	}

	changeHandler = e => {
		this.setState({ [e.target.name]: e.target.value })
	}

	registerTeacher = e => {
		e.preventDefault()
		console.log(this.state)
		axios
			.post('http://localhost:8080/insertteacher', this.state)
			.then(response => {
				console.log(response)
			})
			.catch(error => {
				console.log(error)
			})
	}

	render() {
		const {
            user_id,
         first_name,
        last_name,
        email,
        contact_no,
        qualification,
        address,
        password } = this.state
		return (
			<div className="container"  style={{backgroundImage:"url(/images/background.jpeg)"}}>
                <div className="row">
                    
						
						<div className="col-md-12">
						<form onSubmit={this.registerTeacher} >
						<table className="table table-striped table-bordered">
						<tr><td colspan="2" style={{fontSize:"30px",fontWeight : "bold",textAlign:"center"}}> Teacher Registration</td></tr>
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
								<td style={{fontSize:"20px",textAlign:"center"}}><label for="qualification"> Qualification </label> 
								</td>
									<td>
									
						<input
                        className="form-control"
							type="text"
							name="qualification"
							value={qualification}
                            placeholder="Qualification"
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
								<td colspan="2"> <button class="createBtn" type="submit">Submit</button></td>
								</tr>
							
						</table>
               
					
                    
				</form>
						</div>
                   
		
                    </div>
                </div>
				
                   
                  
                    
                    
					
		);
	}
}

export default Teacher;