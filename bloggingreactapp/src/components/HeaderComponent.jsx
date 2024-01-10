import React, { useState } from 'react';
import NavLogo from '../assets/icons/channel-logo-removebg.png';
import humbergerIcon from '../assets/icons/bars-solid.svg';
import signoutIcon from '../assets/icons/logout-svgrepo-com.svg';
import { Link } from 'react-router-dom';
import { useAuth } from '../security/AuthContext';

function HeaderComponent() {
    return (
        <>
            <Navbar />
        </>
    )
}


const Navbar = () => {
    const [isMobileMenuOpen, setisMobileMenuOpen] = useState(false)
    const authContext = useAuth();
    const isAuthenticated = authContext.isAuthenticated;

    const toggleMobileMenu = () => {
        setisMobileMenuOpen(!isMobileMenuOpen);
    };

    return (
        <div className="NavBar bg-white  fixed top-0 z-10 w-[100%]">
            <nav className="bg-white border-b border-black py-5">
                <div className="mx-auto flex justify-between items-center md:mx-[250px]">

                    <div className="flex items-center">
                        <Link to="/" className="text-white text-lg font-bold"><img src={NavLogo} alt=" " /></Link>
                    </div>

                    <div className={`hidden md:flex space-x-4 text-black justify-center items-center `}>
                        <input
                            type="text"
                            placeholder="Search..."
                            className="hidden md:block bg-white text-black px-2 py-1 rounded-xl mr-4  border-gray-400 hover:border"
                        />
                        {isAuthenticated && <Link to="/" className="text-black hover:underline">Our Story</Link>}
                        {isAuthenticated && <Link to="/" className="text-black hover:underline">MemberShip</Link>}
                        {isAuthenticated && <Link to="/" className="text-black hover:underline">write</Link>}
                        {!isAuthenticated && <Link to="/login" className="text-black hover:underline" id="signin-btn">Sign in</Link>}
                        {isAuthenticated && <Link to="/logout" onClick={() => authContext.logout()} className="text-black flex items-center hover:bg-slate-200 p-2 rounded-full" id="signin-btn">Sign Out <img className='w-4 ml-1' src={signoutIcon} alt="logout" /></Link>}
                        {!isAuthenticated && <Link to="/register"><button
                            className="bg-green-500 px-5 py-2 rounded-full hover:bg-green-600 text-white">Register</button></Link>}
                    </div>

                    <div className="md:hidden">
                        <img onClick={toggleMobileMenu} src={humbergerIcon} className="mx-3 w-6" alt="humberger icon " />
                    </div>
                </div>
            </nav>
            {isMobileMenuOpen &&
                (
                    <div id="mobile-menu" className="md:hidden bg-white p-4 space-y-2 flex flex-col items-start">
                        {isAuthenticated && <Link to="/" onClick={() => setisMobileMenuOpen(!isMobileMenuOpen)} className="text-black hover:underline mx-3">MemberShip</Link>}
                        {isAuthenticated && <Link to="/" onClick={() => setisMobileMenuOpen(!isMobileMenuOpen)} className="text-black hover:underline mx-3">write</Link>}
                        {isAuthenticated && <Link to="/" onClick={() => setisMobileMenuOpen(!isMobileMenuOpen)} className="text-black hover:underline mx-3">Our Story</Link>}
                        {isAuthenticated && <Link to="/" onClick={() => setisMobileMenuOpen(!isMobileMenuOpen)} className="text-black hover:underline mx-3 pt-2">Sign Out</Link>}
                        {!isAuthenticated && <Link to="/logout" onClick={() => authContext.logout()} className="text-black hover:underline mx-3" id="signin-btn">Sign in</Link>}
                        {!isAuthenticated && <Link to="/register"><button onClick={() => setisMobileMenuOpen(!isMobileMenuOpen)}
                            className="bg-green-500 px-5 py-2 rounded-full hover:bg-green-600 text-white">Register</button></Link>}
                    </div>
                )}
        </div>
    );
}






export default HeaderComponent