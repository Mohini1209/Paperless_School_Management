import React from 'react';
import MailIcon from '@material-ui/icons/Mail';
import SchoolIcon from '@material-ui/icons/School';
import CallIcon from '@material-ui/icons/Call';
class Contact extends React.Component{
    constructor(props){
        super(props);
    }
    render(){
        return(
            <div className="container">
                <br/>
                <div className="row ">
                <div className="col-md-6">
                   <img src="/images/contactimg.jpeg" height="550px" width="600px"/> 
                </div>
                <div className="col-md-6">
                <p style={{marginLeft:"80px"}}>
                
                <h3>Wisdom Public School</h3><br/>
               <h5><SchoolIcon/> Address</h5> 
                <p>Near Deccan Gymkhana, <br />
                Pune: 411004 Maharashtra, INDIA
                </p><br/>
                <h5><MailIcon/> Email</h5>
                <p>info@wisdom.co.in</p>
                <br/>
                <h5><CallIcon/> Telephone</h5>
                <p>School Office: 020-25648081/82</p>
                 </p>
           
                </div>
               
                </div>
            </div>
        );
    }
}

export default Contact;