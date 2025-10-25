using System.Data.Entity;

namespace StudentAPI.Models
{
    public class StudentDbContext : DbContext
    {
        public StudentDbContext() : base("DefaultConnection") { }
        public DbSet<Student> Students { get; set; }
    }
}
