<template>
  <div class="card">
    <!-- add (event,landmark-id) -->
    <!-- <button class="deletebtn" @click="deleteItinerary()"   @drop="onDrop($event, landmark_id)" @dragover.prevent @dragenter.prevent> -->
    <div
      class="icon-trash"
      style="float: left"
      @drop="onDrop($event)"
      @dragover.prevent
      @dragenter.prevent
    >
      <div class="trash-lid" style="background-color: #2cc3b5"></div>
      <div class="trash-container" style="background-color: #2cc3b5"></div>
      <div class="trash-line-1"></div>
      <div class="trash-line-2"></div>
      <div class="trash-line-3"></div>
    </div>

    <button class="deletebtn" @click="deleteItinerary()">
      Delete this trip
    </button>

    <div class="mapcard">
      <itinerary-map v-bind:itinerary="this.itinerary" />
    </div>
    <h2>{{ itinerary.itinerary_name }}</h2>

    <div
      v-for="landmark in landmarks"
      v-bind:key="landmark.landmark_id"
      draggable="true"
      @dragstart="startDrag($event, landmark.landmark_id)"
      class="landmark-name"
    >
      {{ landmark.landmark_name }}

      <button class="xbtn" @click="removeLandmark(landmark.landmark_id)">
        X
      </button>
    </div>
  </div>
</template>

<script>
import ItineraryService from "../services/ItineraryService";

import LandmarkService from "../services/LandmarkService";
import ItineraryMap from "./ItineraryMap.vue";

export default {
  components: { ItineraryMap },
  props: {
    itinerary: Object,
  },
  data() {
    return {
      landmarks: [],
    };
  },

  mounted() {
    LandmarkService.getByItinerary(this.itinerary.itinerary_id).then(
      (response) => {
        this.landmarks = response.data;
      }
    );
  },
  methods: {
    removeLandmark(landmark_id) {
      ItineraryService.removeLandmark(this.itinerary.itinerary_id, landmark_id);
      location.reload();
    },
    deleteItinerary() {
      ItineraryService.deleteItinerary(this.itinerary.itinerary_id);
      location.reload();
    },
    startDrag(evt, landmark_id) {
      evt.dataTransfer.dropEffect = "move";
      evt.dataTransfer.effectAllowed = "move";
      evt.dataTransfer.setData("landmark_id", landmark_id);
    },
    onDrop(evt) {
      const landmarkId = evt.dataTransfer.getData("landmark_id");
      ItineraryService.removeLandmark(this.itinerary.itinerary_id, landmarkId);
      location.reload();
    },
  },
};
</script>

<style scoped>
.menu {
  width: 35px;
  height: 5px;
  background-color: black;
  margin: 0;
}
h2 {
  text-shadow: 2px 2px #3498db;
  font-weight: bold;
}
.card {
  background-color: rgba(73, 41, 41, 0.7);
  border-radius: 18px;

  padding: 1em;

  width: 100%;
  position: relative;
}

.deletebtn {
  color: #fff;
  background-color: #112740;
  transition: all 150ms ease-in-out;
  position: absolute;
  top: 0;
  right: 0;
  margin: 5px;
  border-radius: 15%;
  height: 5%;
  margin-top: 3%;
}
.deletebtn:hover {
  background-color: #3498db;
}

.xbtn {
  color: white;

  
  background-color: #e74c3c;

 

  border-radius: 50%;

  cursor: pointer;
  
margin-left: auto;
display: flex;

}
.xbtn:hover {
  background-color: #3498db;
}
.mapcard {
  margin-top: 10%;
  


 
}
.landmark-name {
  height: 30px;
  text-align: center;
  border: solid #ffffff 0.5px;
  margin: 2%;
  border-radius: 10px;
display: flex;
align-items: center;
justify-content: center;
}
.landmark-name:hover {
  color: #112740;
  cursor: -webkit-grab;
}

.landmark-name:active {
  cursor: -webkit-grabbing;
}

.icon-trash {
  width: 35px;
  height: 35px;
  position: relative;
  overflow: hidden;
  float: left;
}

.icon-trash .trash-lid {
  width: 62%;
  height: 10%;
  position: absolute;
  left: 50%;
  margin-left: -31%;
  top: 10.5%;
  background-color: #000;
  border-top-left-radius: 80%;
  border-top-right-radius: 80%;
  -webkit-transform: rotate(-5deg);
  -moz-transform: rotate(-5deg);
  -ms-transform: rotate(-5deg);
  transform: rotate(-5deg);
}

.icon-trash .trash-lid:after {
  content: "";
  width: 26%;
  height: 100%;
  position: absolute;
  left: 50%;
  margin-left: -13%;
  margin-top: -10%;
  background-color: inherit;
  border-top-left-radius: 30%;
  border-top-right-radius: 30%;
  -webkit-transform: rotate(-1deg);
  -moz-transform: rotate(-1deg);
  -ms-transform: rotate(-1deg);
  transform: rotate(-1deg);
}

.icon-trash .trash-container {
  width: 56%;
  height: 65%;
  position: absolute;
  left: 50%;
  margin-left: -28%;
  bottom: 10%;
  background-color: #000;
  border-bottom-left-radius: 15%;
  border-bottom-right-radius: 15%;
}

.icon-trash .trash-container:after {
  content: "";
  width: 110%;
  height: 12%;
  position: absolute;
  left: 50%;
  margin-left: -55%;
  top: 0;
  background-color: inherit;
  border-bottom-left-radius: 45%;
  border-bottom-right-radius: 45%;
}

.icon-trash .trash-line-1 {
  width: 4%;
  height: 50%;
  position: absolute;
  left: 38%;
  margin-left: -2%;
  bottom: 17%;
  background-color: #252527;
}

.icon-trash .trash-line-2 {
  width: 4%;
  height: 50%;
  position: absolute;
  left: 50%;
  margin-left: -2%;
  bottom: 17%;
  background-color: #252527;
}

.icon-trash .trash-line-3 {
  width: 4%;
  height: 50%;
  position: absolute;
  left: 62%;
  margin-left: -2%;
  bottom: 17%;
  background-color: #252527;
}
.icon-trash:hover {
  background-color: #3498db;
}
</style>