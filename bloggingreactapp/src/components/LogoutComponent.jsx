import React from 'react'

function LogoutComponent() {
  return (
    <div>
        <Logout/>
    </div>
  )
}

function Logout() {
    return (
      <div className="LogoutComponent mt-[15rem] md:mx-[250px] mx-4 text-center mb-[36.1vh]">
        <h1>You are logged out!</h1>
        <div>
          Thank you for using our App. Come back soon!
        </div>
      </div>
    )
  }

export default LogoutComponent