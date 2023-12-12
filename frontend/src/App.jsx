import React from "react";
import "./App.css";

import { Route, BrowserRouter as Router, Routes } from "react-router-dom";
import GroupEdit from "./GroupEdit";
import GroupList from "./GroupList";
import Home from "./Home";

const App = () => {
  return (
    <Router>
      <Routes>
        <Route exact path="/" element={<Home />} />
        <Route path="/groups" exact={true} element={<GroupList />} />
        <Route path="/groups/:id" element={<GroupEdit />} />
      </Routes>
    </Router>
  );
};

export default App;
