import React from "react";
import "./App.css";

import Home from "./Home";
import GroupList from "./GroupList";
// import GroupEdit from "./GroupEdit";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

const App = () => {
  return (
    <Router>
      <Routes>
        <Route exact path="/" element={<Home />} />
        <Route path="/groups" exact={true} element={<GroupList />} />
      </Routes>
    </Router>
  );
};

export default App;
