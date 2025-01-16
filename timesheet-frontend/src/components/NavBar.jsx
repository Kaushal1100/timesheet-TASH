
import {Link} from "react-router-dom";
import '../styles/navbar.css';
function NavBar(){

    return (
        <nav style={{ padding: "10px", backgroundColor: "#007bff", color: "white" }}>
            <Link to="/register">Register</Link>
            <Link to="/dashboard" style={{ margin: "0 10px", color: "white", textDecoration: "none" }}>
            Dashboard </Link> 
            <Link to="/add-timesheet" style={{ margin: "0 10px", color: "white", textDecoration: "none" }}>
            Add Timesheet </Link> 
            <Link to="/add-employee" style={{ margin: "0 10px", color: "white", textDecoration: "none" }}>
            Add Employee</Link> 
          
      </nav>
        );
      };
export default NavBar;