function Footer() {
  return (
    <footer>
      <div>
        <p>
          &copy; {new Date().getFullYear()} My Website. All rights reserved.
        </p>
        <p>
          Built with React and Tailwind CSS
        </p>
      </div>
    </footer>
  );
}

export default Footer;