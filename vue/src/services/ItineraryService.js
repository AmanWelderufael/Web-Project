import axios from 'axios';


export default {

    addItinerary(itinerary){
        axios.post('/Itinerary', itinerary)

    },

    search(){
        return axios.get('/Itinerary')
    },

    addLandmark(itinerary_id, landmark){
        axios.post('/Itinerary/'+ itinerary_id, landmark)
    }


}