import React from 'react';

import { HashRouter, Link, Route } from 'react-router-dom';

import Login from './Login.js';
import '../style.css';
import Slider from './Slider.js';

class Home extends React.Component{
    render(){
        return(
           
            <div className="container-fluid">
               
              <br/>
                <div className="row">    
                <div className="col-md-4">
                    <div>
                    <div className="jumbotron"> 
                    
                        <h4>Admissions open for Primary SESSION 2021-2022</h4>
                        <p style={{color:"blue"}}>*No admission fees charged<br/>
                        *No interview will be conducted<br/>
                        </p><br/>
                                <h4>Inspection Report</h4>
                               <p>Overall Effectiveness: Good<br/>
                                    Quality of teaching, Learning and Assessment: Good<br/>
                                    Personal development, behaviour and welfare: Outstanding<br/>
                                    Outcomes  for pupils: Good<br/>
                                    Early Years Provision: Good
</p>
                    </div>
                        <div className="jumbotron">
                            <h4>Upcoming Events</h4>
                            <ul>
                                <li>Virtual Quiz Event</li>
                                <li>Virtual Speech Competition
                                (Topic - Impact of Corona Virus) </li>
                                <li>Story Telling Contest</li>
                                <li>Virtual Dance Competition</li>
                                <li>Craft from Waste Competition</li>
                            </ul>
                        </div>
                    </div>
                 
                </div>
                <div className="col-md-8">
                   <p style={{textAlign:"center",fontWeight:"bold",fontSize:"20px"}}>|| गुरुर्ब्रह्मा ग्रुरुर्विष्णुः गुरुर्देवो महेश्वरः|<br/>
                        गुरुः साक्षात् परं ब्रह्म तस्मै श्री गुरवे नमः॥
                    </p>
                    <Slider/>

                    <h4>Our Vision</h4>
                        <p>We believe that an enjoyment of learning and a desire for knowledge
                             and expertise are the foundation of education. Around the school,
                              there are places of interest, challenge, wonder and reflection; all
                               of which create a stimulating environment to inspire and enthuse.
                               Wisdom Public School is  committed to nurture the inherent potential 
                               and talent of each child, creating lifelong learners who will be the 
                               leaders of tomorrow. With parents as our partners, we aspire to create 
                               global citizens who are innovative and have a strong sense of values.<br/><br/></p>

                </div>
                </div>
            </div>
            
        );
    }
}

export default Home;