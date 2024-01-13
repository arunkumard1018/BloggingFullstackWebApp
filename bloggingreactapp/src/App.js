import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import HeaderComponent from './components/HeaderComponent';
import BlogPostContainer from './containers/BlogPostContainer';
import SignInPage from './pages/SignInPage';
import RegistrationPage from './pages/RegistrationPage';
import BlogPostPage from './pages/BlogPostPage';
import FooterComponent from './components/FooterComponent';
import AuthProvider from './security/AuthContext';
import LogoutComponent from './components/LogoutComponent';
import BlogPost from './components/BlogPost';



function App() {
  return (
    <div className="App">
      <AuthProvider>
        <BrowserRouter>
          <HeaderComponent />

          <Routes>
            <Route path='/' element={<BlogPostContainer />} />
            <Route path='/login' element={<SignInPage />} />
            <Route path='/logout' element={<LogoutComponent />} />
            <Route path='/register' element={<RegistrationPage />} />
            <Route path='/posts/:postId' element={<BlogPostPage />} />
            <Route path='/post' element={<BlogPost />} />
          </Routes>

          <FooterComponent />
        </BrowserRouter>
      </AuthProvider>
    </div>
  );
}



export default App;
