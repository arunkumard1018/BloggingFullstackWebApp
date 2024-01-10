import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import HeaderComponent from './components/HeaderComponent';
import BlogPostContainer from './containers/BlogPostContainer';
import SignInPage from './pages/SignInPage';
import RegistrationPage from './pages/RegistrationPage';
import BlogPostPage from './pages/BlogPostPage';
import FooterComponent from './components/FooterComponent';
import AuthProvider from './security/AuthContext';



function App() {
  return (
    <div className="App">
      <AuthProvider>
        <BrowserRouter>
          <HeaderComponent />

          <Routes>
            <Route path='/' element={<BlogPostContainer />} />
            <Route path='/login' element={<SignInPage />} />
            <Route path='/logout' element={<Logout />} />
            <Route path='/register' element={<RegistrationPage />} />
            <Route path='/posts/:postId' element={<BlogPostPage />} />
          </Routes>

          <FooterComponent />
        </BrowserRouter>
      </AuthProvider>
    </div>
  );
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

export default App;
