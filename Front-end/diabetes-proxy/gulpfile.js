var gulp = require("gulp");
var htmlmin = require("gulp-htmlmin"),
  uglify = require("gulp-uglify"),
  rename = require("gulp-rename");

gulp.task("release", function() {
  gulp.start("minifyhtml", "minifycompiled", "minifylayer");
});

gulp.task("debug", function() {
  gulp.src("pc/src/*.html").pipe(gulp.dest("pc/res/templates/"));
  gulp.src("pc/src/util/minify/*.js").pipe(gulp.dest("pc/res/util"));
  gulp.src("pc/src/util/*.js").pipe(gulp.dest("pc/res/util"));
  gulp.src("pc/src/layui/lay/modules/*.js").pipe(gulp.dest("pc/res/layui/lay/modules"));
});

gulp.task("mobile-release", function() {
  gulp.start("mobile-minifyhtml");
});

gulp.task("mobile-debug", function() {
  gulp.src("mobile/src/*.html").pipe(gulp.dest("mobile/res"));
});

gulp.task("mobile-minifyhtml", function() {
  var options = {
    collapseWhitespace: true,
    collapseBooleanAttributes: true,
    removeComments: true,
    removeEmptyAttributes: true,
    removeScriptTypeAttributes: true,
    removeStyleLinkTypeAttributes: true,
    minifyJS: true,
    minifyCSS: true
  };
  return gulp
    .src("mobile/src/*.html")
    .pipe(htmlmin(options))
    .pipe(gulp.dest("mobile/res/"));
});

gulp.task("minifyhtml", function() {
  var options = {
    collapseWhitespace: true,
    collapseBooleanAttributes: true,
    removeComments: true,
    removeEmptyAttributes: true,
    removeScriptTypeAttributes: true,
    removeStyleLinkTypeAttributes: true,
    minifyJS: true,
    minifyCSS: true
  };
  return gulp
    .src("pc/src/*.html")
    .pipe(htmlmin(options))
    .pipe(gulp.dest("pc/res/templates/"));
});

gulp.task("minifycompiled", function() {
  return gulp
    .src("pc/src/util/minify/*.js")
    .pipe(uglify())
    .pipe(gulp.dest("pc/res/util"));
});
gulp.task("moveutil", function() {
  return gulp.src("pc/src/util/*.js").pipe(gulp.dest("pc/res/util"));
});

gulp.task("minifylayer", function() {
  return gulp
    .src("pc/src/layui/lay/modules/*.js")
    .pipe(uglify())
    .pipe(gulp.dest("pc/res/layui/lay/modules"));
});
