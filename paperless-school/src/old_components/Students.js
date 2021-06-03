import React from "react";


class Std extends React.Component {
  constructor(props){
    super(props);
    this.state = {
      error : null,
      items : []
    };
  }

 async componentDidMount() {
    const url = "http://localhost:8080/allstudents";
   fetch(url)
   .then(res => res.json())
   .then(
     (result) => {
       this.setState({
         items : result
       })
     },
     (error) => {
       this.setState({error})
     }
   )
   

  }

  render() {
    const {error,items} = this.state;
    if(error){
    return(
      <div>Error:{error.message}</div>
    )
    }
    else{
    return (
      
      <div>
      <table cellPadding="50px" border="1">
        <thead>
          <tr>
          <th>First Name</th>
          <th>Last name</th>
          
          </tr>
        </thead>
        <tbody>
       {items.map(item => (
         <tr>
         <td key={item.student_id}> {item.first_name} </td>
         <td>{item.last_name}</td>

         </tr>
       ))}
       </tbody>
      </table>
      </div>
    );
  }
}

}
export default Std;
