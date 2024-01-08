import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import HeaderComponent from './components/HeaderComponent';
import BlogPostContainer from './containers/BlogPostContainer';
import SignInPage from './pages/SignInPage';
import RegistrationPage from './pages/RegistrationPage';
import BlogPostPage from './pages/BlogPostPage';
import FooterComponent from './components/FooterComponent';



function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <HeaderComponent />
        
        <Routes>
          <Route path='/' element={ <BlogPostContainer/> } />
          <Route path='/login' element = { <SignInPage/> } />
          <Route path='/register' element = { <RegistrationPage/> } />
          <Route path='/posts/:postId' element = { <BlogPostPage/> } />
        </Routes>
        <FooterComponent/>
      </BrowserRouter>
    </div>
  );
}

export default App;
