import React from 'react'
import { Link } from 'react-router-dom'

export default function Navbar() {
  return (
    <div>
      <nav className="navbar navbar-expand-lg nvarbar-dark bg-primary">
        <div className="container-fluid">
          <p className="navbar-brand" href="#" style={{ color: "white", textAlign: "center" }}>Management Student</p>
          <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span className="navbar-toggler-icon"></span>
          </button>
          <Link className="btn btn-outline-light" to="/adduser">Add User</Link>
        </div>
      </nav>
    </div>
  )
}
