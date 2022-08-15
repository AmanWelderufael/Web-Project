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
    },

    removeLandmark(itinerary_id, landmark_id){
        axios.delete('Itinerary' + itinerary_id +'/landmark' + landmark_id )

    },

    deleteItinerary(itinerary_id){
        axios.delete("Itinerary/" + itinerary_id)
    }
    


}