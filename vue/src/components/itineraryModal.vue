<template>
  <div class="modal-backdrop">
    <div class="modal">
      <header class="modal-header">
        <slot name="header"> Select an itinerary </slot>
        <button type="button" class="btn-close" @click="close">x</button>
      </header>

      <section  class="modal-body">
        <button
          type="button"
          class="btn-green"
          @click="
            close();
            addToItinerary(itinerary.itinerary_id, itinerary);
            
          "
          v-for="itinerary in itinerariesNotOn"
          v-bind:key="itinerary.itinerary_id"
        >
          Add to: {{ itinerary.itinerary_name }}
        </button>
      </section>
      <section  class="modal-body">
        <button
          type="button"
          class="btn-red"
          @click="
            close();
            removeFromItinerary(itinerary.itinerary_id, itinerary);
            
          "
          v-for="itinerary in itinerariesOn"
          v-bind:key="itinerary.itinerary_id"
        >
          Remove from: {{ itinerary.itinerary_name }}
        </button>
      </section>
   
    </div>
  </div>
</template>

<script>
import ItineraryService from '../services/ItineraryService';
import itineraryService from "../services/ItineraryService";
import LandmarkService from "../services/LandmarkService";

export default {
  name: "Modal",
  data() {
    return {
      itineraries: [],
      landmarksOnItineraries: [],
      itinerariesNotOn: [],
      itinerariesOn: []
    };
  },
  props: {
    landmark: Object,
  },

  methods: {
    close() {
      this.$emit("close");
    },
    addToItinerary(id, itinerary) {
      itineraryService.addLandmark(id, this.landmark);
      const index = this.itinerariesNotOn.indexOf(itinerary);
      this.itinerariesNotOn.splice(index, 1);
      this.itinerariesOn.push(itinerary);

    },
    removeFromItinerary(id, itinerary){
      ItineraryService.removeLandmark(id, this.landmark.landmark_id);
      const index = this.itinerariesOn.indexOf(itinerary);
      this.itinerariesOn.splice(index,1);
      this.itinerariesNotOn.push(itinerary)
    }
  },
  created() {
    itineraryService.search().then((response) => {
      this.itineraries = response.data;

      this.itineraries.forEach((itinerary) => {
        LandmarkService.getByItinerary(itinerary.itinerary_id).then(
          (response) => {
            this.landmarksOnItineraries[itinerary.itinerary_id] = response.data;

            this.itinerariesNotOn = this.itineraries.filter((itinerary) => {
              let foundIt = false;
              this.landmarksOnItineraries[itinerary.itinerary_id].forEach(
                (x) => {
                  if (x.landmark_id == this.landmark.landmark_id) {
                    foundIt = true;
                  }
                }
              );
              return !foundIt;
              
            });
             this.itinerariesOn = this.itineraries.filter((itinerary) => {
              let foundIt = false;
              this.landmarksOnItineraries[itinerary.itinerary_id].forEach(
                (x) => {
                  if (x.landmark_id == this.landmark.landmark_id) {
                    foundIt = true;
                  }
                }
              );
              return foundIt;
              
            });
            
          }
        );
      });
    });
  },
};
</script>

<style scoped>
.modal-backdrop {
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;

  display: flex;
  justify-content: center;
  align-items: center;
}

.modal {
  background: #ffffff;
  
  overflow-x: auto;
  display: flex;
  flex-direction: column;
  margin: 10px 10px 0 0;
  width: 300px;
  border-radius: 10px;
}

.modal-header,
.modal-footer {
  padding: 10px;
  display: flex;
}

.modal-header {
  position: relative;
  border-bottom: 1px solid #eeeeee;
  color: #4aae9b;
  justify-content: space-between;
}

.modal-footer {
  border-top: 1px solid #eeeeee;
  flex-direction: column;
  justify-content: flex-end;
}

.modal-body {
  position: relative;
  padding: 0;
  display: flex;
  flex-direction: column;
  margin: 0;
}

.btn-close {
  position: absolute;
  top: 0;
  right: 0;
  border: none;
  font-size: 20px;
  padding: 10px;
  cursor: pointer;
  font-weight: bold;
  color: #4aae9b;
  background: transparent;
}

.btn-green {
  color: white;
  background: #4aae9b;
  border: 1px solid #4aae9b;
  border-radius: 2px;
  padding: 10px;
}
.btn-red {
  color: white;
  background: #ae4a4a;
  border: 1px solid #ae4a4a;
  border-radius: 2px;
  padding: 10px;
}
button {
  margin: 2px;
}
.btn-green:hover {
  background: #143050;
}
.btn-red:hover {
  background: #ff0000;
}
</style>