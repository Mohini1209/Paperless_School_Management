import logo from './logo.svg';
import './App.css';
import { Link, Route } from 'react-router-dom';
import Home from './components/Home.js';
import Login from './components/Login.js';
import Contact from './components/Contact.js';
import About from './components/About.js';
import StudentHome from './components/StudentHome.js';
import TeacherHome from './components/TeacherHome.js';
import AdminHome from './components/AdminHome.js';

import './style.css';
function App() {
  return (
   <div className="container-fluid">
     <img className="float-left" src="/images/Logo.jpg" height="80px" width="80px"></img>
     <h2 style={{paddingTop:"15px",fontFamily:"cursive",color:"skyblue"}}>Wisdom Public School</h2>
     
     <br/>
     <div className="row">
       
       <div className="col-md-12" class="navdiv">
     <nav>

       <Link to="/" className="text-white">Home</Link>&nbsp;&nbsp;&nbsp;&nbsp;
       <Link to="/contact" className="text-white">Contact</Link>&nbsp;&nbsp;&nbsp;&nbsp;
       <Link to="/about" className="text-white">About</Link>&nbsp;&nbsp;&nbsp;&nbsp;
       <Link to="/login" className="text-white">Login</Link>
     </nav>
     </div>
     </div>
     <div>
       <Route path="/" component={Home} exact/>
       <Route path="/contact" component={Contact} />
        <Route path="/about" component={About} />
       <Route path="/login" component={Login} />
       <Route path="/studenthome/:User_id" render={({match})=> <StudentHome match={match}/>} />
       <Route path="/teacherhome/:User_id" component={TeacherHome} />
       <Route path="/adminhome/:User_id" component={AdminHome} />
       
     </div>
   </div>
  );
}

export default App;
