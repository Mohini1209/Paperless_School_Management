import React, { Component } from 'react';


class AllQueries extends React.Component{

    constructor(props){
        super(props);
        this.state = {
            error: null,
            queries: []
          }
    }
    componentDidMount() {
        const apiUrl = 'http://localhost:8080/allqueries';
    
        fetch(apiUrl)
          .then(res => res.json())
          .then(
            (result) => {
              alert(JSON.stringify(result));
              this.setState({
                queries: result
              });
            },
            (error) => {
              this.setState({ error });
            }
          )
      }
    
    render(){
        const { error, queries} = this.state;
       

    if(error) {
      return (
        <div>Error: {error.message}</div>
      )
    } else {
      return(
        <div>
          <h2 style={{textAlign:"center"}}>Show Queries</h2>
          <table  className="table table-hover table-bordered">
            <thead>
              <tr>
                <th>Student Id</th>
                <th>Queries</th>
                
              </tr>
            </thead>
            <tbody>
              {this.state.queries.map(query=> (
                <tr key={query.student_id}>
                  <td>{query.question}</td>
                  
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )
    }
    }
}

export default AllQueries;