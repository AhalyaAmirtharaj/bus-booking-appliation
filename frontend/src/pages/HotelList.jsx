export default function HotelList() {
  const [hotels, setHotels] = useState([]);
  useEffect(() => { getAllHotels().then(r => setHotels(r.data)); }, []);
  // return hotel cards with name, location, rating, View Rooms button
  // clicking View Rooms → navigate('/rooms/' + hotel.id)
}