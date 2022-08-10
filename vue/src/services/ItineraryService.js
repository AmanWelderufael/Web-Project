import axios from 'axios';

export default {

    addItinerary(itinerary){
        axios.post('/Itinerary', itinerary)

    }

}