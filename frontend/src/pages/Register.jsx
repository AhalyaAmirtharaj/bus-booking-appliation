export default function Register() {
  const [form, setForm] = useState({name:'',email:'',password:'',phone:''});
  const handleChange = (e) => setForm({...form,[e.target.name]:e.target.value});
  const handleSubmit = async (e) => {
    e.preventDefault();
    const res = await registerUser(form);
    localStorage.setItem('userId', res.data.id);
    navigate('/hotels');
  };
  // return form JSX with inputs for name, email, password, phone
}