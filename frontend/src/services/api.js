import axios from 'axios';
const BASE_URL = 'http://localhost:8080/api';
export const registerUser = (data) => axios.post(`${BASE_URL}/auth/register`, data);
export const getAllHotels = () => axios.get(`${BASE_URL}/hotels`);
export const searchHotels = (loc) => axios.get(`${BASE_URL}/hotels/search/${loc}`);
export const getRoomsByHotel = (id) => axios.get(`${BASE_URL}/rooms/hotel/${id}`);
export const bookRoom = (data) => axios.post(`${BASE_URL}/bookings`, data);
export const getUserBookings = (id) => axios.get(`${BASE_URL}/bookings/user/${id}`);
export const cancelBooking = (id) => axios.put(`${BASE_URL}/bookings/${id}/cancel`)