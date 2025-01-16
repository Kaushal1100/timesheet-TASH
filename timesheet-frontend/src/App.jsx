
import {BrowserRouter as Router,Routes,Route} from "react-router-dom";
import Login from "./pages/Login.jsx";
import './App.css'
import NavBar from "./components/navbar.jsx";
import Dashboard from "./pages/Dashboard.jsx";
import Profile from "./pages/Profile.jsx";
import AddTimesheet from "./pages/AddTimesheet.jsx";
import AddEmployee from "./pages/AddEmployee.jsx";
import Register from "./components/Register.jsx";
function App() {
 
  return (
    <>
       <Router>
        <NavBar/>
        <Routes>
            <Route path="/" element={<Login/>}/>
            <Route path="/register" element={<Register/>} />
            <Route path="/dashboard" element={<Dashboard/>}/>
            <Route path="/add-timesheet" element={<AddTimesheet />} />
            <Route path="/profile" element={<Profile />} />
            <Route path="/add-employee" element={<AddEmployee/>}/>
        </Routes>
      </Router> 
    </>
  );
};
export default App
