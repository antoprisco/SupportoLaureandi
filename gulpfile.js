var gulp = require('gulp'),
    clean = require('gulp-clean'),
    sass = require('gulp-sass'),
    autoprefixer = require('gulp-autoprefixer'),
    uglify = require('gulp-uglify'),
    rename = require('gulp-rename'),
    pump = require('pump');            

var base_path = './WebContent',
    paths = {
        scripts: base_path + '/assets/js',        
        clean: base_path + '/css/styleEV.css',
        input: base_path + '/sass/**/*.scss',
        output: base_path + '/css'
    };

gulp.task('minify', function() {    
    pump([
        gulp.src(paths.scripts + '/*.js'),
        uglify(),
        rename(function(path) { path.extname = ".min.js" }),
        gulp.dest(paths.scripts)
    ]);
});      

gulp.task('clean', function() {
    return gulp.src([paths.clean], { read: false })
        .pipe(clean());
});

gulp.task('sass', ['clean'], function() {
    var sassOptions = {};
    //var sassOptions = { outputStyle: 'compressed' };

    return gulp.src(paths.input)
        .pipe(sass(sassOptions))
        .pipe(gulp.dest(paths.output));
});

gulp.task('postprocess', ['sass'], function() {
    return gulp.src(paths.output).pipe(autoprefixer());
});

gulp.task('build', ['postprocess']);

gulp.task('watch', function() {
    return gulp.watch(paths.input, ['build'])
    .on('change', function(event) {
        console.log('File ' + event.path + ' was ' + event.type + ', running tasks...');
    });
});


gulp.task('default', ['build', 'watch']);
