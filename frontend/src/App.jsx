import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Login from './Login';
import Dashboard from './Dashboard';
import Logout from './Logout'; // Import the new Logout component

const App = () => {
    return (
        <Router>
            <Routes>
                <Route path="/login" element={<Login />} />
                <Route path="/dashboard" element={<Dashboard />} />
                <Route path="/logout" element={<Logout />} /> {/* Add Logout route */}
            </Routes>
        </Router>
    );
};

export default App;
