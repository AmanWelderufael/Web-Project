import axios from 'axios';
export default {
   search() {
       return axios.get('/retrieveLandMark')
   },
   getByID(id){
        return axios.get('/landmark/'+id)
   },
   getByItinerary(itinerary){
       return axios.get('/Itinerary/landmark', itinerary )
   }
}