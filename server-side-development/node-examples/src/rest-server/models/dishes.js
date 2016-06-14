var mongoose = require('mongoose')
var Schema = mongoose.Schema

var dishSchema = new Schema({
    name: {
        type: String,
        required: true,
        unique: true
    },
    description: {
        type: String,
        required: true
    }
}, {
    timestamps: true
})

module.exports = mongoose.model('Dish', dishSchema)
