
import React from 'react';


 
class UploadStudyMaterial extends React.Component{
    constructor(props)
    {
        super(props);
        this.state = {
        subjects : [],
        chapters : [],
        chap_id:null,
        chap_nm:null,
        updateContent:{chapter_id:null,chapter_name:null,content:null,subject_id:null,},
       
          selectSubValue : 0,
          selectChapterValue : 0,
          selectedOption: null
        }
        this.handleSubChange = this.handleSubChange.bind(this);
        this.handleChapterChange = this.handleChapterChange.bind(this);
    }
    
    componentDidMount=()=>{

         fetch("http://localhost:8080/selectsubject?user_id="+sessionStorage.getItem("teacher_id"),{method:'post'})
        .then(response=> response.json())
        .then(
            (result) => {
            // alert(JSON.stringify(result));
            this.setState({
                subjects: result
              });
            })
          

           
     }
    

     handleSubChange(e){
        
        this.setState({selectSubValue: e.target.value});
        fetch("http://localhost:8080/selectchapter?user_id="+sessionStorage.getItem("teacher_id")+"&subject_id="+e.target.value)
        .then(response=> response.json())
        .then(
            (res) => {
            //  alert(JSON.stringify(res));
           
            this.setState({
                chapters: res,
               
              });
            
            })
          
      };

     handleChapterChange(e){
        this.setState({selectChapterValue:e.target.value});
      };

     upload = () =>
     {
        let contentText= this.refs.content.value;
   let lchapobj={chapter_id:this.state.selectChapterValue,chapter_name:this.state.chap_nm,subject_id:this.state.selectSubValue,content:contentText }
    const requestOptions = {
         method: 'POST',
         headers:{
                   'Content-Type':'application/json'
                },
        body: JSON.stringify(lchapobj),
            }
     fetch("http://localhost:8080/updatecontent",requestOptions)
        alert("Updated")
        .then(response=> response.json())
        .then(
            (data) => {
              //  alert(JSON.stringify(data));
            })
            
     }
    
   
    render(){
        const {subjects} = this.state.subjects;
        const {chapters} = this.state.chapters;
        return(
            
            <div className="container-fuild" >
                
                <form className="form-group" onSubmit={this.upload}>
                <table className="table table-striped, table-border">
               <tr>
                        <td style={{fontSize:"20px",fontWeight : "bold"}}>Select Subject </td>
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
                        <td  style={{fontSize:"20px",fontWeight : "bold"}}>Select Chapter </td>
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
                        <td style={{fontSize:"20px",fontWeight : "bold"}}>Write Content</td>
                        <td>
                                     <textarea rows="5" cols="76" ref="content" name="content" placeholder="Write Content....">

                                     </textarea>
                        </td>
                    </tr>
                   
                    <tr>
                    <td colspan="2"><input type="submit" className="btn btn-block btn-primary"  value="Upload"/></td>
                    </tr>
                </table>
                </form>
                
                <br/>
                
            </div>
        );
    }
}

export default UploadStudyMaterial;