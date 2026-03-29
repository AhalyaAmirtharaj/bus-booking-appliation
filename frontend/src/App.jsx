import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Register from './pages/Register';
import Login from './pages/Login';
import Home from './pages/Home';
import BusList from './pages/BusList';
import SeatSelection from './pages/SeatSelection';
import MyTickets from './pages/MyTickets';
import './styles/App.css';
export default function App() {
return (
<Router>
<nav>
<Link to='/home'>Home</Link>
<Link to='/register'>Register</Link>
<Link to='/login'>Login</Link>
<Link to='/my-tickets'>My Tickets</Link>
</nav>
<Routes>
<Route path='/' element={<Home />} />
<Route path='/home' element={<Home />} />
<Route path='/register' element={<Register />} />
<Route path='/login' element={<Login />} />
<Route path='/buses' element={<BusList />} />
<Route path='/seats/:routeId' element={<SeatSelection />} />
<Route path='/my-tickets' element={<MyTickets />} />
</Routes>
</Router>
);
}