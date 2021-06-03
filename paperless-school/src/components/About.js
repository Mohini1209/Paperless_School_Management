import React from 'react';

class About extends React.Component{
    constructor(props){
        super(props);
    }
    render(){
        return(
            <div className="container-fluid">
                <br/>

                <img className="mx-auto d-block" src="/images/aboutimg.jpeg" height="400px" width="800px" />
                
                <p><br/>
                    Wisdom Public School was founded in the year 1983 by Prof. Vishwanath D. Karad 
                    (Founder, Executive President and Director General), along with the collective
                     efforts of many educationists, scientists and social  thinkers. WPS is one of 
                     the first few private Public School in the state, now offering academic 
                     programs in various cities for over 500 students annually.
                     At Wisdom we aim to ensure that all children develop to their full potential
                      and that we prepare them for the opportunities and experiences for adult life.
                       We aim to achieve this by providing high quality teaching and learning in a happy, 
                       inclusive community.
                       <br/><br/>
                       <ul>
                           <li> At Wisdom we provide an education which places importance on the development of 
                    the whole child, academically, intellectually, physically, emotionally and socially.</li>
                           <li> We provide a safe and happy environment that raises children’s self-esteem and a 
                    balanced creative curriculum that develops the whole child.</li>
                           <li> We have high expectations for behaviour and achievement. If necessary we work
                     closely with parents whose child is experiencing difficulties.</li>
                           <li> We have a strong Governing Body who are committed to our vision and support 
                    and challenge us to achieve it.</li>
                    <li>We provide equal opportunities for learning regardless of gender, culture, race,
                     creed or ethnic origin. Where each person is valued and is made aware that they 
                     have the potential to make a positive contribution to the school.</li>
                       </ul>
                       
                     <br/>
                     </p>
                     
                     <p style={{textAlign:"center"}}>
                     <h5>Our School Reflection</h5><br/>
                     We always work our hardest and try our best<br/>

                    We like to have fun when learning<br/>

                    Taking pride, aiming high<br/>

                    And never giving up
                    <br/><br/>
                    We are proud of our beautiful environment<br/>

                    Taking care to look after it<br/>

                    We always help and look after each other<br/>

                    We never walk away
                    <br/><br/>
                    Our teachers believe in us and help us<br/>

                    When we find things challenging<br/>

                    Celebrating success is very important to us<br/>

                    However small this may be.


                </p>
            </div>
        );
    }
}

export default About;