import React from 'react';
import AliceCarousel from 'react-alice-carousel';
import "react-alice-carousel/lib/alice-carousel.css";
import '../style.css';


class Slider extends React.Component{
    render(){
        return(
            <div>
                <AliceCarousel autoPlay autoPlayInterval="3000">
                    
                    <img src="/images/slider5.jpeg" height="370px" width="750px" className="sliderimg mx-auto d-block"/>
                    <img src="/images/school.jpg" height="370px" width="750px" className="sliderimg mx-auto d-block"/>
                    <img src="/images/school2.jpg" height="370px" width="750px" className="sliderimg mx-auto d-block"/>
                    <img src="/images/slider7.jpeg" height="370px" width="750px" className="sliderimg mx-auto d-block"/>
                    <img src="/images/slider2.jpeg" height="370px" width="750px" className="sliderimg mx-auto d-block"/>
                    <img src="/images/slider3.jpeg" height="370px" width="750px" className="sliderimg mx-auto d-block"/>
                    <img src="/images/slider4.jpeg" height="370px" width="750px" className="sliderimg mx-auto d-block"/>
                    
                </AliceCarousel>            
            </div>
        );
    }
}
export default Slider;