import  Select from 'react-select';
import React, { Component } from 'react';
import '../style.css';
import axios from 'axios';

class AssignClass extends React.Component{

    constructor(props){
        super(props);
        this.state={
            teachers:[],
            classes : [
                {label : "I", value:1},
                {label : "II", value:2},
                {label : "III", value:3},
                {label : "IV", value:4},
                {label : "V", value:5},
               
              ],
              selectTeacherValue : "select",
              selectClassValue : "select",
              selectedOption: null
        };
        this.handleChange = this.handleChange.bind(this);
        this.handleClassChange = this.handleClassChange.bind(this);
    }

    componentDidMount=()=>{
        fetch("http://localhost:8080/allteachers")
        .then(response=> response.json())
        .then(data => this.setState({teachers: data}));

       
     }
     
     handleChange(e){
        this.setState({selectTeacherValue:e.target.value});
      //  alert("set t value : "+ this.state.selectTeacherValue);
      };
     assignClass = e => {
		e.preventDefault()
		console.log(this.state)
        //alert("method call");
       // alert((this.state.teachers.t_id));
       
		axios
			.post('http://localhost:8080/assignclass?t_id='+(this.state.selectTeacherValue)+'&class_id='+(this.state.selectClassValue))
            
			.then(response => {
				console.log(response)
			})
            
			.catch(error => {
				console.log(error)
			})
            alert("Class Assign Successfully.... !!!");
	}

    // handleClassChange = selectedOption => {
    //     this.setState({ selectedOption });
    //     console.log(`Option selected:`, selectedOption);
    //   };

    handleClassChange(e){
        this.setState({selectClassValue:e.target.value});
        alert("set class value : "+ this.state.selectClassValue);
      };

    render(){
        //const { selectValue } = this.state;
        const { selectedOption } = this.state;
        return(
            <div className="container">
                <div className="row">
                    <div className="col-md-8">
                        <form >
                        <table className="table table-striped table-border">
                        <tr>
                                <td style={{fontSize:"20px"}}>Select Teacher</td>
                                <td>
                                <select name="teacher" className="form-control" value={this.state.selectTeacherValue} 
        onChange={this.handleChange} >
                                <option value="select">Select Teacher</option>
                                     {
                                         
                                         this.state.teachers.map(t=>
                                             { return(
                                                  <option value={t.t_id}>{t.first_name} {t.last_name}</option>
                                              )  }
                                         )
                                     }
                                 </select>   
                                </td>
                                <div>Selected value is : {this.state.selectTeacherValue}</div>
                            </tr>
                            <tr>
                                <td style={{fontSize:"20px"}}>Select Class</td>
                                <td>
                                {/*<Select  option={classes} placeholder="Select Class" >

                                 </Select>*/}
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
                            
                            </tr>
                            
                            <tr> 
                                <td colspan="2"><input type="button" class="commonBtn" onClick={this.assignClass}  value="Assign"/></td>
                            </tr>
                        </table>
                        </form>
                    </div>
                    <div className="col-md-4"></div>
                </div>
            </div>
        );
    }
}

export default AssignClass;