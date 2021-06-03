import React from 'react';
import axios from 'axios';

 
class ViewStudyMaterial extends React.Component{
    constructor(props)
    {
        super(props);
        this.state = {
        subjects : [],
        chapters : [],
        content1 : "",
          selectSubValue : 0,
          selectChapterValue : 0,
          selectedOption: null
        }
        this.handleSubChange = this.handleSubChange.bind(this);
        this.handleChapterChange = this.handleChapterChange.bind(this);
    }
    
    componentDidMount=()=>{
         fetch("http://localhost:8080/selectsubjectstud?user_id="+sessionStorage.getItem("student_id"))
        .then(response=> response.json())
        .then(
            (result) => {
          //   alert(JSON.stringify(result));
            this.setState({
                subjects: result
              });
            })
          

           
     }
   
     handleSubChange(e){
        
        this.setState({selectSubValue: e.target.value});
       // alert("sub"+e.target.value)
       
        

        fetch("http://localhost:8080/selectchapterstud?user_id="+sessionStorage.getItem("student_id")+"&subject_id="+e.target.value)
        .then(response=> response.json())
        .then(
            (res) => {
            //  alert(JSON.stringify(res));
            //  alert(res.length);
            this.setState({
                chapters: res
              });
            })
      };
     handleChapterChange(e){
        this.setState({selectChapterValue:e.target.value});
      //  alert("set class value : "+ e.target.value);
      };
    showContent = (e) =>
    {
    //  alert("method call");
      e.preventDefault();
     let url = "http://localhost:8080/showcontent?subjectid="+this.state.selectSubValue+"&chapterid="+this.state.selectChapterValue;
     
      fetch(url,{method:"post"})
     
      .then(response=> response.json())
      
      .then(data => {
      //  alert(".......")
        //alert(JSON.stringify(data))
        this.setState({content1: data.content})},
        //alert("content : "+this.state.content1)
        )
      
    }
    render(){
       const {subjects,chapters,content1} = this.state;
      
        return(
            
            <div className="container-fuild" >
                
                <form className="form-group" onSubmit={this.showContent}>
                <table className="table table-striped, table-border">
               <tr>
                        <td colspan="2" style={{fontSize:"20px",fontWeight : "bold"}}>Select Subject </td>
                        <td>
                        <select name="subject" ref="subjects" className="form-control"  value={this.state.selectSubValue}
        onChange={this.handleSubChange} >
                               <option>Select Subject</option>
                                     {
                                         
                                         this.state.subjects.map(s=>
                                             { return(
                                                  <option value={s.subject_id}>{s.subject_name}</option>
                                              )  }
                                         )
                                     }
                                 </select> 
                        </td>
                        <td>{this.state.selectSubValue}</td>
                    </tr>
                    <tr>
                        <td colspan="2" style={{fontSize:"20px",fontWeight : "bold"}}>Select Chapter </td>
                        <td>
                        <select name="chapters" className="form-control" value={this.state.selectChapterValue}
        onChange={this.handleChapterChange} >
                                <option>Select Chapter</option>
                                     {
                                         
                                         this.state.chapters.map(c=>
                                             { return(
                                                  <option value={c.chapter_id}>{c.chapter_name}</option>
                                              )  }
                                         )
                                     }
                                 </select> 
                        </td>
                        <td>{this.state.selectChapterValue}</td>
                    </tr>
                     <tr>
                    <td colspan="2"><input type="submit" className="btn  btn-primary"  value="Show Content"/></td>
                    </tr>
                    
                </table>
               
                </form>
                <div>
               
                Content : <br/>
               <a href={this.state.content1}>
                      {
                   this.state.content1
                    
                
                  }
                  </a>
                </div>
                <br/>
               
            </div>
        );
    }
}

export default ViewStudyMaterial;