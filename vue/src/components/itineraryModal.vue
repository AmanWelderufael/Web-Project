<template>
  <div class="modal-backdrop">
    <div class="modal">
      <header class="modal-header">
        <slot name="header"> Select an itinerary </slot> 
        <button type="button" class="btn-close" @click="close">x</button>
      </header>

      <section class="modal-body">
        
        <button
          type="button"
          class="btn-green"
          @click="
            close();
            addToItinerary(itinerary.itinerary_id);
          "
          v-for="itinerary in itineraries"
          v-bind:key="itinerary.itinerary_id"
        >
          {{ itinerary.itinerary_name }}
        </button>
        
        
      </section>
    </div>
  </div>
</template>

<script>
import itineraryService from "../services/ItineraryService";

export default {
  name: "Modal",
  data() {
    return {
      itineraries: [],
    };
  },
  props: {
    landmark: Object,
  },
  methods: {
    close() {
      this.$emit("close");
    },
    addToItinerary(id) {
      itineraryService.addLandmark(id, this.landmark);
    },
  },
  created() {
    itineraryService.search().then((response) => {
      this.itineraries = response.data;
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
  box-shadow: 3px 3px 10px rgba(0,0,0,.3);
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
button {
  margin: 2px;
}
button:hover {
  background: #143050;
}


</style>