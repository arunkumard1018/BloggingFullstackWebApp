import React, { useState } from 'react'
import NavLogo from '../assets/icons/channel-logo-removebg.png'
import humbergerIcon from '../assets/icons/bars-solid.svg'

function HeaderComponent() {
    return (
        <>
            <Navbar />
        </>
    )
}


const Navbar = () => {
    const [isMobileMenuOpen, setisMobileMenuOpen] = useState(false)
    const toggleMobileMenu = () => {
        setisMobileMenuOpen(!isMobileMenuOpen);
        console.log(isMobileMenuOpen)
    };

    return (
        <div className="NavBar bg-white  fixed top-0 z-10 w-[100%]">
            <nav className="bg-white border-b border-black py-5">
                <div className="mx-auto flex justify-between items-center md:mx-[250px]">

                    <div className="flex items-center">
                        <a href="/" className="text-white text-lg font-bold"><img src={NavLogo} alt=" " /></a>
                    </div>

                    <div className={`hidden md:flex space-x-4 text-black justify-center items-center `}>
                    <input
                        type="text"
                        placeholder="Search..."
                        className="hidden md:block bg-white text-black px-2 py-1 rounded-xl mr-4  border-gray-400 hover:border"
                    />

                        <a href="/" className="text-black hover:underline">Our Story</a>
                        <a href="/" className="text-black hover:underline">MemberShip</a>
                        <a href="/" className="text-black hover:underline">write</a>
                        <a href="/" className="text-black hover:underline" id="signin-btn">Sign in</a>
                        <a href="/register"><button
                            className="bg-green-500 px-5 py-2 rounded-full hover:bg-green-600 text-white">Register</button></a>
                    </div>

                    <div className="md:hidden">
                        <img onClick={toggleMobileMenu} src={humbergerIcon} className="mx-3 w-6" alt="humberger icon " />
                    </div>
                </div>
            </nav>
            {isMobileMenuOpen &&
                (
                    <div id="mobile-menu" className="md:hidden bg-white p-4 space-y-2 flex flex-col items-start">
                        <a href="/" className="text-black hover:underline mx-3">MemberShip</a>
                        <a href="/" className="text-black hover:underline mx-3">write</a>
                        <a href="/" className="text-black hover:underline mx-3">Our Story</a>
                        <a href="/" className="text-black hover:underline mx-3" id="signin-btn">Sign in</a>
                        <a href="/register"><button
                            className="bg-green-500 px-5 py-2 rounded-full hover:bg-green-600 text-white">Register</button></a>
                    </div>
                )}

        </div>
    );
}






export default HeaderComponent